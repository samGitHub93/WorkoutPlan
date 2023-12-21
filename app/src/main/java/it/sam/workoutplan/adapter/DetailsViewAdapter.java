package it.sam.workoutplan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.sam.workoutplan.R;
import it.sam.workoutplan.enumerator.CardioKey;
import it.sam.workoutplan.enumerator.Category;
import it.sam.workoutplan.enumerator.WeightliftingKey;
import it.sam.workoutplan.model.parameter.Buffer;
import it.sam.workoutplan.model.parameter.Duration;
import it.sam.workoutplan.model.parameter.Goal;
import it.sam.workoutplan.model.parameter.LastPerformance;
import it.sam.workoutplan.model.parameter.Notes;
import it.sam.workoutplan.model.parameter.Pause;
import it.sam.workoutplan.model.parameter.Percentage;
import it.sam.workoutplan.model.parameter.Reps;
import it.sam.workoutplan.model.parameter.Rpe;
import it.sam.workoutplan.model.parameter.Weight;
import it.sam.workoutplan.model.set.CardioSet;
import it.sam.workoutplan.model.set.WeightliftingSet;
import it.sam.workoutplan.model.set.WorkoutSet;
import it.sam.workoutplan.view_holder.DetailsViewHolder;

public class DetailsViewAdapter<K, V> extends RecyclerView.Adapter<DetailsViewHolder> {

    private final List<? extends WorkoutSet<K, V>> exerciseWorkoutSets;

    public DetailsViewAdapter(List<? extends WorkoutSet<K, V>> exerciseWorkoutSets) {
        this.exerciseWorkoutSets = exerciseWorkoutSets;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise_details, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        if(exerciseWorkoutSets.get(0).getCategory() == Category.WEIGHTLIFTING)
            bindWeightliftingDetails(holder, position);
        else if(exerciseWorkoutSets.get(0).getCategory() == Category.CARDIO)
            bindCardioDetails(holder, position);
    }

    @Override
    public int getItemCount() {
        return exerciseWorkoutSets.size();
    }

    public void bindWeightliftingDetails(@NonNull DetailsViewHolder holder, final int position) {
        WeightliftingSet weightliftingSet = (WeightliftingSet) exerciseWorkoutSets.get(position);
        holder.getWeight().setText(((Weight) weightliftingSet.get(WeightliftingKey.WEIGHT)).getValuePlusUnitOfMeasure());
        holder.getRpe().setText(((Rpe) weightliftingSet.get(WeightliftingKey.RPE)).getValuePlusUnitOfMeasure());
        holder.getBuffer().setText(((Buffer) weightliftingSet.get(WeightliftingKey.BUFFER)).getValue());
        holder.getPause().setText(((Pause) weightliftingSet.get(WeightliftingKey.PAUSE)).getValuePlusUnitOfMeasure());
        holder.getPercentage().setText(((Percentage) weightliftingSet.get(WeightliftingKey.PERCENTAGE)).getValuePlusUnitOfMeasure());
        holder.getReps().setText(((Reps) weightliftingSet.get(WeightliftingKey.REPS)).getValue());
        holder.getNotes().setText(((Notes) weightliftingSet.get(WeightliftingKey.NOTES)).getValue());
        postWeightliftingHolderManagement(holder);
    }

    public void bindCardioDetails(@NonNull DetailsViewHolder holder, final int position) {
        CardioSet cardioSet = (CardioSet) exerciseWorkoutSets.get(position);
            holder.getDuration().setText(((Duration) cardioSet.get(CardioKey.DURATION)).getValuePlusUnitOfMeasure());
            holder.getGoal().setText(((Goal) cardioSet.get(CardioKey.GOAL)).getValue());
            holder.getLastPerformance().setText(((LastPerformance) cardioSet.get(CardioKey.LAST_PERFORMANCE)).getValuePlusUnitOfMeasure());
        postCardioHolderManagement(holder);
    }

    private void postWeightliftingHolderManagement(@NonNull DetailsViewHolder holder){
        if(holder.getWeight() != null && holder.isEmpty(holder.getWeight()))
            holder.getWeight().setVisibility(View.GONE);
        if(holder.getBuffer() != null && holder.isEmpty(holder.getBuffer()))
            holder.getBuffer().setVisibility(View.GONE);
        if(holder.getNotes() != null && holder.isEmpty(holder.getNotes()))
            holder.getNotes().setVisibility(View.GONE);
        if(holder.getPause() != null && holder.isEmpty(holder.getPause()))
            holder.getPause().setVisibility(View.GONE);
        if(holder.getPercentage() != null && holder.isEmpty(holder.getPercentage()))
            holder.getPercentage().setVisibility(View.GONE);
        if(holder.getReps() != null && holder.isEmpty(holder.getReps()))
            holder.getReps().setVisibility(View.GONE);
        if(holder.getRpe() != null && holder.isEmpty(holder.getRpe()))
            holder.getRpe().setVisibility(View.GONE);
    }

    private void postCardioHolderManagement(@NonNull DetailsViewHolder holder){
        if(holder.getDuration() != null && holder.isEmpty(holder.getDuration()))
            holder.getDuration().setVisibility(View.GONE);
        if(holder.getGoal() != null && holder.isEmpty(holder.getGoal()))
            holder.getGoal().setVisibility(View.GONE);
        if(holder.getLastPerformance() != null && holder.isEmpty(holder.getLastPerformance()))
            holder.getLastPerformance().setVisibility(View.GONE);
    }
}
