package it.sam.workoutplan.view_holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import it.sam.workoutplan.R;

public class WorkoutPlanViewHolder extends RecyclerView.ViewHolder {

    private final MaterialCardView materialCardView;
    private final ImageView icon;
    private final TextView title;
    private final TextView generalNotes;

    public WorkoutPlanViewHolder(@NonNull View itemView) {
        super(itemView);
        materialCardView = itemView.findViewById(R.id.workout_plan_card);
        icon = materialCardView.findViewById(R.id.workout_plan_settings);
        title = materialCardView.findViewById(R.id.workout_plan_title);
        generalNotes = materialCardView.findViewById(R.id.workout_plan_general_notes);
    }

    public MaterialCardView getMaterialCardView() {
        return materialCardView;
    }

    public ImageView getIcon() {
        return icon;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getGeneralNotes() {
        return generalNotes;
    }
}
