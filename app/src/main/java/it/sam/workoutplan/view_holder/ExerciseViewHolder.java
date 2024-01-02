package it.sam.workoutplan.view_holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import it.sam.workoutplan.R;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {

    private final MaterialCardView materialCardView;
    private final ImageView icon;
    private final TextView title;
    private final TextView bodyParts;
    private final RecyclerView recyclerView;
    private final TextView generalNotes;

    public ExerciseViewHolder(@NonNull View itemView) {
        super(itemView);
        materialCardView = itemView.findViewById(R.id.exercise_card);
        icon = materialCardView.findViewById(R.id.exercise_icon);
        title = materialCardView.findViewById(R.id.exercise_title);
        bodyParts = materialCardView.findViewById(R.id.exercise_body_parts);
        recyclerView = materialCardView.findViewById(R.id.recycler_details);
        generalNotes = materialCardView.findViewById(R.id.exercise_general_notes);
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

    public TextView getBodyParts() {
        return bodyParts;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public TextView getGeneralNotes() {
        return generalNotes;
    }

    public Boolean isEmpty(TextView textView){
        return textView.getText() == null || textView.getText().toString().equals("") || textView.getText().toString().equals("Text Example");
    }
}
