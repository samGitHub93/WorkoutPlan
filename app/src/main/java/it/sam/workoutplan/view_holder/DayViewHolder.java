package it.sam.workoutplan.view_holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import it.sam.workoutplan.R;

public class DayViewHolder extends RecyclerView.ViewHolder {

    private final MaterialCardView materialCardView;
    private final ImageView icon;
    private final TextView title;
    private final TextView generalNotes;

    public DayViewHolder(@NonNull View itemView) {
        super(itemView);
        materialCardView = itemView.findViewById(R.id.day_card);
        icon = materialCardView.findViewById(R.id.day_settings);
        title = materialCardView.findViewById(R.id.day_title);
        generalNotes = materialCardView.findViewById(R.id.day_general_notes);
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
