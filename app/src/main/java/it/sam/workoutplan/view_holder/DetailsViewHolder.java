package it.sam.workoutplan.view_holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import it.sam.workoutplan.R;

public class DetailsViewHolder extends RecyclerView.ViewHolder {

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

    public DetailsViewHolder(@NonNull View itemView) {
        super(itemView);
        LinearLayout itemDetails = itemView.findViewById(R.id.item_details);
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

    public Boolean isEmpty(TextView textView){
        return textView.getText().toString().equals("") || textView.getText().toString().equals("Text Example");
    }
}
