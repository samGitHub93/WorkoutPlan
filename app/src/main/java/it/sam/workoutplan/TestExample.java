package it.sam.workoutplan;

import android.app.Activity;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import it.sam.workoutplan.adapter.WorkoutPlanViewAdapter;
import it.sam.workoutplan.database.WorkoutPlanDatabase;
import it.sam.workoutplan.database.model.RoomWorkoutPlan;
import it.sam.workoutplan.enumerator.BodyPart;
import it.sam.workoutplan.enumerator.CardioKey;
import it.sam.workoutplan.enumerator.WeightliftingKey;
import it.sam.workoutplan.model.ExerciseDay;
import it.sam.workoutplan.model.WorkoutPlan;
import it.sam.workoutplan.model.exercise.CardioExercise;
import it.sam.workoutplan.model.exercise.StretchExercise;
import it.sam.workoutplan.model.exercise.WeightliftingExercise;
import it.sam.workoutplan.model.parameter.Duration;
import it.sam.workoutplan.model.parameter.Goal;
import it.sam.workoutplan.model.parameter.LastPerformance;
import it.sam.workoutplan.model.parameter.Notes;
import it.sam.workoutplan.model.parameter.Pause;
import it.sam.workoutplan.model.parameter.Reps;
import it.sam.workoutplan.model.parameter.Weight;
import it.sam.workoutplan.model.set.CardioSet;
import it.sam.workoutplan.model.set.WeightliftingSet;
import it.sam.workoutplan.model_mapper.ModelMapper;

public class TestExample {

    public static void run(Context context) throws Exception {
        WorkoutPlanDatabase database = WorkoutPlanDatabase.getDatabase(context);
        database.roomWorkoutPlanDao().deleteAll();

        WeightliftingExercise weightliftingExercise_1 = new WeightliftingExercise();
        weightliftingExercise_1.setName("Lat Machine");
        weightliftingExercise_1.setBodyParts(Arrays.asList(BodyPart.LOWER_BACK, BodyPart.BICEPS));
        WeightliftingSet weightliftingSet_1 = new WeightliftingSet();
        weightliftingSet_1.put(WeightliftingKey.WEIGHT, new Weight("62,5"));
        weightliftingSet_1.put(WeightliftingKey.REPS, new Reps("4"));
        weightliftingSet_1.put(WeightliftingKey.PAUSE, new Pause("1.30"));
        weightliftingSet_1.put(WeightliftingKey.NOTES, new Notes("note note note note note"));
        WeightliftingSet weightliftingSet_2 = new WeightliftingSet();
        weightliftingSet_2.put(WeightliftingKey.WEIGHT, new Weight("62,5"));
        weightliftingSet_2.put(WeightliftingKey.REPS, new Reps("4"));
        weightliftingSet_2.put(WeightliftingKey.PAUSE, new Pause("1.30"));
        weightliftingSet_2.put(WeightliftingKey.NOTES, new Notes("note note note note note"));
        WeightliftingSet weightliftingSet_3 = new WeightliftingSet();
        weightliftingSet_3.put(WeightliftingKey.WEIGHT, new Weight("62,5"));
        weightliftingSet_3.put(WeightliftingKey.REPS, new Reps("4"));
        weightliftingSet_3.put(WeightliftingKey.PAUSE, new Pause("1.30"));
        weightliftingSet_3.put(WeightliftingKey.NOTES, new Notes("note note note note note"));
        WeightliftingSet weightliftingSet_4 = new WeightliftingSet();
        weightliftingSet_4.put(WeightliftingKey.WEIGHT, new Weight("62,5"));
        weightliftingSet_4.put(WeightliftingKey.REPS, new Reps("4"));
        weightliftingSet_4.put(WeightliftingKey.PAUSE, new Pause("1.30"));
        weightliftingSet_4.put(WeightliftingKey.NOTES, new Notes("note note note note note"));
        weightliftingExercise_1.setWeightliftingSets(Arrays.asList(weightliftingSet_1, weightliftingSet_2, weightliftingSet_3, weightliftingSet_4));
        weightliftingExercise_1.setGenericNotes("Height: 3");

        WeightliftingExercise weightliftingExercise_2 = new WeightliftingExercise();
        weightliftingExercise_2.setName("Chest press");
        weightliftingExercise_2.setBodyParts(Collections.singletonList(BodyPart.CHEST));
        WeightliftingSet weightliftingSet_5 = new WeightliftingSet();
        weightliftingSet_5.put(WeightliftingKey.WEIGHT, new Weight("40"));
        weightliftingSet_5.put(WeightliftingKey.REPS, new Reps("6"));
        weightliftingSet_5.put(WeightliftingKey.PAUSE, new Pause("0.30"));
        weightliftingSet_5.put(WeightliftingKey.NOTES, new Notes("note note note note note"));
        WeightliftingSet weightliftingSet_6 = new WeightliftingSet();
        weightliftingSet_6.put(WeightliftingKey.WEIGHT, new Weight("40"));
        weightliftingSet_6.put(WeightliftingKey.REPS, new Reps("5"));
        weightliftingSet_6.put(WeightliftingKey.PAUSE, new Pause("0.30"));
        weightliftingSet_6.put(WeightliftingKey.NOTES, new Notes("note note note note note"));
        WeightliftingSet weightliftingSet_7 = new WeightliftingSet();
        weightliftingSet_7.put(WeightliftingKey.WEIGHT, new Weight("40"));
        weightliftingSet_7.put(WeightliftingKey.REPS, new Reps("4"));
        weightliftingSet_7.put(WeightliftingKey.PAUSE, new Pause("0.30"));
        weightliftingSet_7.put(WeightliftingKey.NOTES, new Notes("note note note note note"));
        WeightliftingSet weightliftingSet_8 = new WeightliftingSet();
        weightliftingSet_8.put(WeightliftingKey.WEIGHT, new Weight("40"));
        weightliftingSet_8.put(WeightliftingKey.REPS, new Reps("3"));
        weightliftingSet_8.put(WeightliftingKey.PAUSE, new Pause("0.30"));
        weightliftingSet_8.put(WeightliftingKey.NOTES, new Notes("note note note note note"));
        weightliftingExercise_2.setWeightliftingSets(Arrays.asList(weightliftingSet_5, weightliftingSet_6, weightliftingSet_7, weightliftingSet_8));
        weightliftingExercise_2.setGenericNotes("Height: 5");

        WeightliftingExercise weightliftingExercise_3 = new WeightliftingExercise();
        weightliftingExercise_3.setName("Pulley");
        weightliftingExercise_3.setBodyParts(Collections.singletonList(BodyPart.LOWER_BACK));
        WeightliftingSet weightliftingSet_9 = new WeightliftingSet();
        weightliftingSet_9.put(WeightliftingKey.WEIGHT, new Weight("55"));
        weightliftingSet_9.put(WeightliftingKey.REPS, new Reps("15 + 10 + 5 + 5"));
        weightliftingSet_9.put(WeightliftingKey.PAUSE, new Pause("0.30"));
        weightliftingSet_9.put(WeightliftingKey.NOTES, new Notes("Rest-pause"));
        weightliftingExercise_3.setWeightliftingSets(Collections.singletonList(weightliftingSet_9));
        weightliftingExercise_3.setGenericNotes("Short distance");

        CardioExercise cardioExercise = new CardioExercise();
        cardioExercise.setName("Hand bike");
        CardioSet cardioSet = new CardioSet();
        cardioSet.put(CardioKey.DURATION, new Duration("20"));
        cardioSet.put(CardioKey.GOAL, new Goal("watt", "180"));
        cardioSet.put(CardioKey.LAST_PERFORMANCE, new LastPerformance("192 watt, 22 min"));
        cardioExercise.setCardioSet(cardioSet);

        StretchExercise stretchExercise = new StretchExercise();
        stretchExercise.setName("Stretching");
        stretchExercise.setBodyParts(Collections.singletonList(BodyPart.LEGS));
        stretchExercise.setGenericNotes("10 min");

        ExerciseDay exerciseDay = new ExerciseDay();
        exerciseDay.setDayName("Monday");
        exerciseDay.setGeneralNotes("Chest, Back, Biceps, Cardio");
        exerciseDay.setExercises(Arrays.asList(
                weightliftingExercise_1,
                weightliftingExercise_2,
                weightliftingExercise_3,
                cardioExercise,
                stretchExercise
        ));

        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setWorkoutPlanName("Plan 1");
        workoutPlan.setGeneralNotes("WEIGHTLIFTING, STRENGTH, CARDIO");
        workoutPlan.setExerciseDays(Collections.singletonList(exerciseDay));

        List<RoomWorkoutPlan> roomWorkoutPlans = ModelMapper.toRoomWorkoutPlans(Collections.singletonList(workoutPlan));

        database.roomWorkoutPlanDao().insertAll(roomWorkoutPlans);

        // -------------------------------------------------------------------------------------

        List<RoomWorkoutPlan> list = database.roomWorkoutPlanDao().getAll();

        WorkoutPlanViewAdapter adapter = new WorkoutPlanViewAdapter(context, ModelMapper.toModelWorkoutPlans(list));
        RecyclerView recyclerView = ((Activity)context).findViewById(R.id.recycler_workout_plan_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }
}
