package it.sam.workoutplan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.sam.workoutplan.ExerciseDayActivity;
import it.sam.workoutplan.ExerciseListActivity;
import it.sam.workoutplan.R;
import it.sam.workoutplan.model.WorkoutPlan;
import it.sam.workoutplan.view_holder.WorkoutPlanViewHolder;

public class WorkoutPlanViewAdapter extends RecyclerView.Adapter<WorkoutPlanViewHolder> {

    private final Context context;
    private final List<WorkoutPlan> workoutPlans;

    public WorkoutPlanViewAdapter(Context context, List<WorkoutPlan> workoutPlans) {
        this.context = context;
        this.workoutPlans = workoutPlans;
    }

    @NonNull
    @Override
    public WorkoutPlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workout_plan, parent, false);
        return new WorkoutPlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutPlanViewHolder holder, int position) {
        WorkoutPlan workoutPlan = workoutPlans.get(position);
        holder.getTitle().setText(workoutPlan.getWorkoutPlanName());
        holder.getGeneralNotes().setText(workoutPlan.getGeneralNotes());
        // TODO: holder.getIcon().setOnClickListener();
        holder.getMaterialCardView().setOnClickListener(onClick(position));
    }

    @Override
    public int getItemCount() {
        return workoutPlans.size();
    }

    private View.OnClickListener onClick(int position){
        return v -> {
            Intent intent = new Intent (v.getContext(), ExerciseDayActivity.class);
            intent.putExtra("position_WP", position);
            v.getContext().startActivity(intent);
        };
    }
}
