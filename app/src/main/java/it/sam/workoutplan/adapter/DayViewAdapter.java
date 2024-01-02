package it.sam.workoutplan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.sam.workoutplan.ExerciseListActivity;
import it.sam.workoutplan.R;
import it.sam.workoutplan.model.ExerciseDay;
import it.sam.workoutplan.view_holder.DayViewHolder;

public class DayViewAdapter  extends RecyclerView.Adapter<DayViewHolder>{

    private final Context context;
    private final List<ExerciseDay> exerciseDayList;
    private final int position_WP;

    public DayViewAdapter(Context context, List<ExerciseDay> exerciseDayList, int position_WP) {
        this.context = context;
        this.exerciseDayList = exerciseDayList;
        this.position_WP = position_WP;
    }

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
        return new DayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        ExerciseDay day = exerciseDayList.get(position);
        holder.getTitle().setText(day.getDayName());
        holder.getGeneralNotes().setText(day.getGeneralNotes());
        // TODO: holder.getIcon().setOnClickListener();
        holder.getMaterialCardView().setOnClickListener(onClick(position));
    }

    @Override
    public int getItemCount() {
        return exerciseDayList.size();
    }

    private View.OnClickListener onClick(int position){
        return v -> {
            Intent intent = new Intent (v.getContext(), ExerciseListActivity.class);
            intent.putExtra("position_WP", position_WP);
            intent.putExtra("position_D", position);
            v.getContext().startActivity(intent);
        };
    }
}
