package it.sam.workoutplan.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import it.sam.workoutplan.database.dao.RoomWorkoutPlanDao;
import it.sam.workoutplan.database.model.Converter;
import it.sam.workoutplan.database.model.RoomWorkoutPlan;

@Database(entities = {RoomWorkoutPlan.class}, version = 1, exportSchema = true)
@TypeConverters({Converter.class})
public abstract class WorkoutPlanDatabase extends RoomDatabase {

    private static volatile WorkoutPlanDatabase INSTANCE;

    public static WorkoutPlanDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (new Object()) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, WorkoutPlanDatabase.class, "workout_plan_db_1")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract RoomWorkoutPlanDao roomExerciseDayDao();
}
