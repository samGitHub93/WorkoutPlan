package it.sam.workoutplan.database.model;

import java.util.List;

public class RoomExerciseDay {

    private String exercises;

    public RoomExerciseDay() {}

    public RoomExerciseDay(List<RoomExercise> exercises) {
        this.exercises = Converter.fromExercisesToString(exercises);
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    public List<RoomExercise> getExercises() {
        return Converter.fromStringToExercises(exercises);
    }

    public void setExercises(List<RoomExercise> exercises) {
        this.exercises = Converter.fromExercisesToString(exercises);
    }
}
