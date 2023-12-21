package it.sam.workoutplan.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import it.sam.workoutplan.database.model.RoomExerciseDay;
import it.sam.workoutplan.database.model.RoomWorkoutPlan;

@Dao
public interface RoomWorkoutPlanDao {
    @Query("SELECT * FROM roomWorkoutPlan")
    List<RoomWorkoutPlan> getAll();

    @Query("SELECT * FROM roomWorkoutPlan WHERE id LIKE (:id)")
    RoomWorkoutPlan getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<RoomWorkoutPlan> roomWorkoutPlans);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RoomWorkoutPlan roomWorkoutPlan);

    @Query("DELETE FROM roomWorkoutPlan")
    void deleteAll();

    @Delete
    void delete(RoomWorkoutPlan roomWorkoutPlan);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(RoomWorkoutPlan roomWorkoutPlan);
}
