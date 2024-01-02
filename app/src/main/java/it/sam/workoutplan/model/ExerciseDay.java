package it.sam.workoutplan.model;

import java.util.List;

import it.sam.workoutplan.model.exercise.Exercise;

public class ExerciseDay {

    private String dayName;
    private List<Exercise> exercises;
    private String generalNotes;

    public String getGeneralNotes() {
        return generalNotes;
    }

    public void setGeneralNotes(String generalNotes) {
        this.generalNotes = generalNotes;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public ExerciseDay() {}
    public ExerciseDay(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
