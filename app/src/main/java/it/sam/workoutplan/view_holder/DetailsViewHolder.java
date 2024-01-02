package it.sam.workoutplan.view_holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import it.sam.workoutplan.R;

public class DetailsViewHolder extends RecyclerView.ViewHolder {

    private final LinearLayout itemDetailsNames;
    private final LinearLayout itemDetailsParameters;
    private final TextView reps;
    private final TextView weight;
    private final TextView pause;
    private final TextView buffer;
    private final TextView rpe;
    private final TextView percentage;
    private final TextView duration;
    private final TextView goal;
    private final TextView lastPerformance;
    private final TextView notes;
    private final TextView repsName;
    private final TextView weightName;
    private final TextView pauseName;
    private final TextView bufferName;
    private final TextView rpeName;
    private final TextView percentageName;
    private final TextView durationName;
    private final TextView goalName;
    private final TextView lastPerformanceName;
    private final TextView notesName;

    public DetailsViewHolder(@NonNull View itemView) {
        super(itemView);
        LinearLayout itemDetails = itemView.findViewById(R.id.item_details);
        itemDetailsNames = itemView.findViewById(R.id.item_details_names);
        itemDetailsParameters = itemView.findViewById(R.id.item_details_parameters);
        reps = itemDetails.findViewById(R.id.exercise_reps);
        rpe = itemDetails.findViewById(R.id.exercise_rpe);
        weight = itemDetails.findViewById(R.id.exercise_weight);
        pause = itemDetails.findViewById(R.id.exercise_pause);
        buffer = itemDetails.findViewById(R.id.exercise_buffer);
        percentage = itemDetails.findViewById(R.id.exercise_percentage);
        notes = itemDetails.findViewById(R.id.exercise_notes);
        duration = itemDetails.findViewById(R.id.exercise_duration);
        goal = itemDetails.findViewById(R.id.exercise_goal);
        lastPerformance = itemDetails.findViewById(R.id.exercise_last_performance);
        repsName = itemDetails.findViewById(R.id.exercise_reps_name);
        rpeName = itemDetails.findViewById(R.id.exercise_rpe_name);
        weightName = itemDetails.findViewById(R.id.exercise_weight_name);
        pauseName = itemDetails.findViewById(R.id.exercise_pause_name);
        bufferName = itemDetails.findViewById(R.id.exercise_buffer_name);
        percentageName = itemDetails.findViewById(R.id.exercise_percentage_name);
        notesName = itemDetails.findViewById(R.id.exercise_notes_name);
        durationName = itemDetails.findViewById(R.id.exercise_duration_name);
        goalName = itemDetails.findViewById(R.id.exercise_goal_name);
        lastPerformanceName = itemDetails.findViewById(R.id.exercise_last_performance_name);
    }

    public LinearLayout getItemDetailsNames() {
        return itemDetailsNames;
    }

    public LinearLayout getItemDetailsParameters() {
        return itemDetailsParameters;
    }

    public TextView getReps() {
        return reps;
    }

    public TextView getWeight() {
        return weight;
    }

    public TextView getPause() {
        return pause;
    }

    public TextView getBuffer() {
        return buffer;
    }

    public TextView getRpe() {
        return rpe;
    }

    public TextView getPercentage() {
        return percentage;
    }

    public TextView getDuration() {
        return duration;
    }

    public TextView getGoal() {
        return goal;
    }

    public TextView getLastPerformance() {
        return lastPerformance;
    }

    public TextView getNotes() {
        return notes;
    }

    public TextView getRepsName() {
        return repsName;
    }

    public TextView getWeightName() {
        return weightName;
    }

    public TextView getPauseName() {
        return pauseName;
    }

    public TextView getBufferName() {
        return bufferName;
    }

    public TextView getRpeName() {
        return rpeName;
    }

    public TextView getPercentageName() {
        return percentageName;
    }

    public TextView getDurationName() {
        return durationName;
    }

    public TextView getGoalName() {
        return goalName;
    }

    public TextView getLastPerformanceName() {
        return lastPerformanceName;
    }

    public TextView getNotesName() {
        return notesName;
    }

    public Boolean isEmpty(TextView textView){
        return textView.getText() != null && (textView.getText().equals("") || textView.getText().equals("Text Example"));
    }
}
