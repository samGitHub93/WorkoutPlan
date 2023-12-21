package it.sam.workoutplan.model;

import java.util.List;

public class WorkoutPlan {

    private String workoutPlanName;
    private List<ExerciseDay> exerciseDays;

    public String getWorkoutPlanName() {
        return workoutPlanName;
    }

    public void setWorkoutPlanName(String workoutPlanName) {
        this.workoutPlanName = workoutPlanName;
    }

    public List<ExerciseDay> getExerciseDays() {
        return exerciseDays;
    }

    public void setExerciseDays(List<ExerciseDay> exerciseDays) {
        this.exerciseDays = exerciseDays;
    }
}
