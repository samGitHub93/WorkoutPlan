package it.sam.workoutplan.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "roomWorkoutPlan")
public class RoomWorkoutPlan {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "exerciseDays")
    private String exerciseDays;

    @ColumnInfo(name = "generalNotes")
    private String generalNotes;

    public RoomWorkoutPlan() {}

    @Ignore
    public RoomWorkoutPlan(int id, List<RoomExerciseDay> exerciseDays) {
        this.id = id;
        this.exerciseDays = Converter.fromDaysToString(exerciseDays);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExerciseDays() {
        return exerciseDays;
    }

    public void setExerciseDays(String exerciseDays) {
        this.exerciseDays = exerciseDays;
    }

    public List<RoomExerciseDay> get() {
        return Converter.fromStringToDays(exerciseDays);
    }

    public void set(List<RoomExerciseDay> exerciseDays) {
        this.exerciseDays = Converter.fromDaysToString(exerciseDays);
    }
}
