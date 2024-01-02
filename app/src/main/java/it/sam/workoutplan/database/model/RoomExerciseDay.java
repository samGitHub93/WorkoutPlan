package it.sam.workoutplan.database.model;

import java.util.List;

public class RoomExerciseDay {

    private String name;
    private String exercises;
    private String generalNotes;

    public RoomExerciseDay() {}

    public RoomExerciseDay(List<RoomExercise> exercises) {
        this.exercises = Converter.fromExercisesToString(exercises);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneralNotes() {
        return generalNotes;
    }

    public void setGeneralNotes(String generalNotes) {
        this.generalNotes = generalNotes;
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
