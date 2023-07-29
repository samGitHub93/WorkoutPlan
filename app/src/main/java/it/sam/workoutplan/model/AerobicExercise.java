package it.sam.workoutplan.model;

import java.util.List;

import it.sam.workoutplan.enumerator.Category;

public class AerobicExercise extends Exercise {

    private String duration;
    private String goal;
    private String lastPerformance;
    private final Category category = Category.CARDIO;

    public AerobicExercise() {}

    public AerobicExercise(String duration, String goal, String lastPerformance) {
        this.duration = duration;
        this.goal = goal;
        this.lastPerformance = lastPerformance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getLastPerformance() {
        return lastPerformance;
    }

    public void setLastPerformance(String lastPerformance) {
        this.lastPerformance = lastPerformance;
    }

    public Category getCategory() {
        return category;
    }
}
