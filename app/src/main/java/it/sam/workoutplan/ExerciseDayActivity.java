package it.sam.workoutplan;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.sam.workoutplan.adapter.DayViewAdapter;
import it.sam.workoutplan.database.WorkoutPlanDatabase;
import it.sam.workoutplan.database.model.RoomWorkoutPlan;
import it.sam.workoutplan.model.ExerciseDay;
import it.sam.workoutplan.model.WorkoutPlan;
import it.sam.workoutplan.model_mapper.ModelMapper;

public class ExerciseDayActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_list);
        Intent intent = getIntent();
        int position_WP = intent.getIntExtra("position_WP", 0);
        try {
            WorkoutPlanDatabase database = WorkoutPlanDatabase.getDatabase(this);

            List<RoomWorkoutPlan> list = database.roomWorkoutPlanDao().getAll();
            List<WorkoutPlan> workoutPlans = ModelMapper.toModelWorkoutPlans(list);

            WorkoutPlan workoutPlan = workoutPlans.get(position_WP);

            List<ExerciseDay> exerciseDays = workoutPlan.getExerciseDays();

            DayViewAdapter adapter = new DayViewAdapter(this, exerciseDays, position_WP);
            RecyclerView recyclerView = findViewById(R.id.recycler_day_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
