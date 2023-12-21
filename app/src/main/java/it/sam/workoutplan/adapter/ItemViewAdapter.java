package it.sam.workoutplan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.sam.workoutplan.R;
import it.sam.workoutplan.enumerator.BodyPart;
import it.sam.workoutplan.enumerator.CardioKey;
import it.sam.workoutplan.enumerator.Category;
import it.sam.workoutplan.enumerator.WeightliftingKey;
import it.sam.workoutplan.model.exercise.CardioExercise;
import it.sam.workoutplan.model.exercise.Exercise;
import it.sam.workoutplan.model.exercise.StretchExercise;
import it.sam.workoutplan.model.exercise.WeightliftingExercise;
import it.sam.workoutplan.model.parameter.CardioParameter;
import it.sam.workoutplan.model.parameter.WeightliftingParameter;
import it.sam.workoutplan.model.set.CardioSet;
import it.sam.workoutplan.model.set.WeightliftingSet;
import it.sam.workoutplan.view_holder.ItemViewHolder;

public class ItemViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private final Context context;
    private final List<Exercise> exercises;

    public ItemViewAdapter(Context context, List<Exercise> exercises) {
        this.context = context;
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {
        Exercise exercise = exercises.get(position);
        Category category = exercise.getCategory();
        if(category == Category.WEIGHTLIFTING) {
            buildWeightliftingHolder(holder, exercise);
        }else if(category == Category.CARDIO){
            buildCardioHolder(holder, exercise);
        }else{
            buildStretchHolder(holder, exercise);
        }
        holder.getTitle().setText(exercise.getName());
        holder.getGeneralNotes().setText(exercise.getGenericNotes());
        postHolderManagement(holder);
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    private void buildWeightliftingHolder(@NonNull ItemViewHolder holder, Exercise exercise){
        WeightliftingExercise weightliftingExercise = (WeightliftingExercise) exercise;
        holder.getIcon().setImageResource(R.drawable.asset_anaerobic_exercise);
        List<BodyPart> bodyParts = weightliftingExercise.getBodyParts();
        String bodyPartsString = getBodyPartsString(bodyParts);
        holder.getBodyParts().setText(bodyPartsString);
        List<WeightliftingSet> weightliftingSets = new ArrayList<>(weightliftingExercise.getWeightliftingSets());
        DetailsViewAdapter<WeightliftingKey, WeightliftingParameter> adapter = new DetailsViewAdapter<>(weightliftingSets);
        holder.getRecyclerView().setLayoutManager(new LinearLayoutManager(context));
        holder.getRecyclerView().setAdapter(adapter);
    }

    private void buildCardioHolder(ItemViewHolder holder, Exercise exercise) {
        CardioExercise cardioExercise = (CardioExercise) exercise;
        holder.getIcon().setImageResource(R.drawable.asset_aerobic_exercise);
        holder.getBodyParts().setText(R.string.cardio_string);
        List<CardioSet> cardioSets = new ArrayList<>(Collections.singletonList(cardioExercise.getCardioSet()));
        DetailsViewAdapter<CardioKey, CardioParameter> adapter = new DetailsViewAdapter<>(cardioSets);
        holder.getRecyclerView().setLayoutManager(new LinearLayoutManager(context));
        holder.getRecyclerView().setAdapter(adapter);
    }

    private void buildStretchHolder(ItemViewHolder holder, Exercise exercise) {
        StretchExercise stretchExercise = (StretchExercise) exercise;
        holder.getIcon().setImageResource(R.drawable.asset_stretch_exercise);
        List<BodyPart> bodyParts = stretchExercise.getBodyParts();
        String bodyPartsString = getBodyPartsString(bodyParts);
        holder.getBodyParts().setText(bodyPartsString);
    }

    private void postHolderManagement(@NonNull ItemViewHolder holder){
        if(holder.getTitle() != null && holder.isEmpty(holder.getTitle()))
            holder.getTitle().setVisibility(View.GONE);
        if(holder.getBodyParts() != null && holder.isEmpty(holder.getBodyParts()))
            holder.getBodyParts().setVisibility(View.GONE);
        if(holder.getGeneralNotes() != null && holder.isEmpty(holder.getGeneralNotes()))
            holder.getGeneralNotes().setVisibility(View.GONE);
    }

    private String getBodyPartsString(List<BodyPart> bodyParts){
        StringBuilder bodyPartsStringBuilder = new StringBuilder();
        for (BodyPart cat : bodyParts) {
            bodyPartsStringBuilder.append(", ").append(cat);
        }
        String bodyPartsString = bodyPartsStringBuilder.toString();
        bodyPartsString = bodyPartsString.substring(2);
        return bodyPartsString;
    }
}
