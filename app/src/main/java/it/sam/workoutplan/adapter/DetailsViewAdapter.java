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
        visibilityManagement(holder, position);
    }

    @Override
    public int getItemCount() {
        return exerciseWorkoutSets.size();
    }

    public void bindWeightliftingDetails(@NonNull DetailsViewHolder holder, final int position) {
        WeightliftingSet weightliftingSet = (WeightliftingSet) exerciseWorkoutSets.get(position);
        if(weightliftingSet.get(WeightliftingKey.WEIGHT) != null)
            holder.getWeight().setText(((Weight) weightliftingSet.get(WeightliftingKey.WEIGHT)).getValuePlusUnitOfMeasure());
        if(weightliftingSet.get(WeightliftingKey.RPE) != null)
            holder.getRpe().setText(((Rpe) weightliftingSet.get(WeightliftingKey.RPE)).getValuePlusUnitOfMeasure());
        if(weightliftingSet.get(WeightliftingKey.BUFFER) != null)
            holder.getBuffer().setText(((Buffer) weightliftingSet.get(WeightliftingKey.BUFFER)).getValue());
        if(weightliftingSet.get(WeightliftingKey.PAUSE) != null)
            holder.getPause().setText(((Pause) weightliftingSet.get(WeightliftingKey.PAUSE)).getValuePlusUnitOfMeasure());
        if(weightliftingSet.get(WeightliftingKey.PERCENTAGE) != null)
            holder.getPercentage().setText(((Percentage) weightliftingSet.get(WeightliftingKey.PERCENTAGE)).getValuePlusUnitOfMeasure());
        if(weightliftingSet.get(WeightliftingKey.REPS) != null)
                holder.getReps().setText(((Reps) weightliftingSet.get(WeightliftingKey.REPS)).getValue());
        if(weightliftingSet.get(WeightliftingKey.NOTES) != null)
            holder.getNotes().setText(((Notes) weightliftingSet.get(WeightliftingKey.NOTES)).getValue());
    }

    public void bindCardioDetails(@NonNull DetailsViewHolder holder, final int position) {
        CardioSet cardioSet = (CardioSet) exerciseWorkoutSets.get(position);
        if(cardioSet.get(CardioKey.DURATION) != null)
            holder.getDuration().setText(((Duration) cardioSet.get(CardioKey.DURATION)).getValuePlusUnitOfMeasure());
        if(cardioSet.get(CardioKey.GOAL) != null)
            holder.getGoal().setText(((Goal) cardioSet.get(CardioKey.GOAL)).getValue());
        if(cardioSet.get(CardioKey.LAST_PERFORMANCE) != null)
            holder.getLastPerformance().setText(((LastPerformance) cardioSet.get(CardioKey.LAST_PERFORMANCE)).getValuePlusUnitOfMeasure());
    }

    private void visibilityManagement(@NonNull DetailsViewHolder holder, final int position){
        if(holder.isEmpty(holder.getWeight())) {
            holder.getWeight().setVisibility(View.GONE);
            holder.getWeightName().setVisibility(View.GONE);
        }
        if(holder.isEmpty(holder.getBuffer())) {
            holder.getBuffer().setVisibility(View.GONE);
            holder.getBufferName().setVisibility(View.GONE);
        }
        if(holder.isEmpty(holder.getNotes())) {
            holder.getNotes().setVisibility(View.GONE);
            holder.getNotesName().setVisibility(View.GONE);
        }
        if(holder.isEmpty(holder.getPause())) {
            holder.getPause().setVisibility(View.GONE);
            holder.getPauseName().setVisibility(View.GONE);
        }
        if(holder.isEmpty(holder.getPercentage())) {
            holder.getPercentage().setVisibility(View.GONE);
            holder.getPercentageName().setVisibility(View.GONE);
        }
        if(holder.isEmpty(holder.getReps())) {
            holder.getReps().setVisibility(View.GONE);
            holder.getRepsName().setVisibility(View.GONE);
        }
        if(holder.isEmpty(holder.getRpe())) {
            holder.getRpe().setVisibility(View.GONE);
            holder.getRpeName().setVisibility(View.GONE);
        }
        if(holder.isEmpty(holder.getDuration())) {
            holder.getDuration().setVisibility(View.GONE);
            holder.getDurationName().setVisibility(View.GONE);
        }
        if(holder.isEmpty(holder.getGoal())) {
            holder.getGoal().setVisibility(View.GONE);
            holder.getGoalName().setVisibility(View.GONE);
        }
        if(holder.isEmpty(holder.getLastPerformance())) {
            holder.getLastPerformance().setVisibility(View.GONE);
            holder.getLastPerformanceName().setVisibility(View.GONE);
        }
        if(position != 0) holder.getItemDetailsNames().setVisibility(View.GONE);
    }
}
