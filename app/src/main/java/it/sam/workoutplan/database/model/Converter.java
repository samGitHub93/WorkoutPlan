package it.sam.workoutplan.database.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.sam.workoutplan.enumerator.BodyPart;
import it.sam.workoutplan.enumerator.CardioKey;
import it.sam.workoutplan.enumerator.Category;
import it.sam.workoutplan.enumerator.WeightliftingKey;
import it.sam.workoutplan.model.parameter.Buffer;
import it.sam.workoutplan.model.parameter.CardioParameter;
import it.sam.workoutplan.model.parameter.Duration;
import it.sam.workoutplan.model.parameter.Goal;
import it.sam.workoutplan.model.parameter.LastPerformance;
import it.sam.workoutplan.model.parameter.Notes;
import it.sam.workoutplan.model.parameter.Pause;
import it.sam.workoutplan.model.parameter.Percentage;
import it.sam.workoutplan.model.parameter.Reps;
import it.sam.workoutplan.model.parameter.Rpe;
import it.sam.workoutplan.model.parameter.Weight;
import it.sam.workoutplan.model.parameter.WeightliftingParameter;
import it.sam.workoutplan.model.set.CardioSet;
import it.sam.workoutplan.model.set.WeightliftingSet;

public class Converter {

    @TypeConverter
    public static List<BodyPart> fromStringToBodyParts(String value) {
        Type listType = new TypeToken<List<BodyPart>>(){}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromBodyPartsToString(List<BodyPart> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public static List<WeightliftingSet> fromStringToWeightliftingSets(String value) {
        Type listType = new TypeToken<List<String>>(){}.getType();
        List<String> strings = new Gson().fromJson(value, listType);
        List<WeightliftingSet> weightliftingSets = new ArrayList<>();
        for(String string : strings){
            Map<WeightliftingKey, WeightliftingParameter> map = stringToWeightliftingSet(string);
            weightliftingSets.add(new WeightliftingSet(map));
        }
        return weightliftingSets;
    }

    @TypeConverter
    public static String fromWeightliftingSetsToString(List<WeightliftingSet> list) throws JSONException {
        List<String> strings = new ArrayList<>();
        for(WeightliftingSet weightliftingSet : list){
            String string = weightliftingSetToString(weightliftingSet);
            strings.add(string);
        }
        Gson gson = new Gson();
        return gson.toJson(strings);
    }

    @TypeConverter
    public static List<CardioSet> fromStringToCardioSets(String value) {
        Type listType = new TypeToken<List<String>>(){}.getType();
        List<String> strings = new Gson().fromJson(value, listType);
        List<CardioSet> cardioSets = new ArrayList<>();
        for(String string : strings){
            Map<CardioKey, CardioParameter> map = stringToCardioSet(string);
            cardioSets.add(new CardioSet(map));
        }
        return cardioSets;
    }

    @TypeConverter
    public static String fromCardioSetsToString(List<CardioSet> cardioSets) throws JSONException {
        List<String> strings = new ArrayList<>();
        for(CardioSet cardioSet : cardioSets){
            String string = cardioSetToString(cardioSet);
            strings.add(string);
        }
        Gson gson = new Gson();
        return gson.toJson(strings);
    }

    @TypeConverter
    public static List<RoomExercise> fromStringToExercises(String value) {
        Type listType = new TypeToken<List<RoomExercise>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromExercisesToString(List<RoomExercise> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public static List<RoomExerciseDay> fromStringToDays(String value) {
        Type listType = new TypeToken<List<RoomExerciseDay>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromDaysToString(List<RoomExerciseDay> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public static Category fromStringToCategory(String value) {
        return Category.valueOf(value);
    }

    private static String weightliftingSetToString(WeightliftingSet weightliftingSet) throws JSONException {
        List<String> strings = new ArrayList<>();
        if(weightliftingSet.get(WeightliftingKey.WEIGHT) != null)
            strings.add(weightliftingSet.get(WeightliftingKey.WEIGHT).toJson());
        if(weightliftingSet.get(WeightliftingKey.REPS) != null)
            strings.add(weightliftingSet.get(WeightliftingKey.REPS).toJson());
        if(weightliftingSet.get(WeightliftingKey.RPE) != null)
            strings.add(weightliftingSet.get(WeightliftingKey.RPE).toJson());
        if(weightliftingSet.get(WeightliftingKey.BUFFER) != null)
            strings.add(weightliftingSet.get(WeightliftingKey.BUFFER).toJson());
        if(weightliftingSet.get(WeightliftingKey.PAUSE) != null)
            strings.add(weightliftingSet.get(WeightliftingKey.PAUSE).toJson());
        if(weightliftingSet.get(WeightliftingKey.NOTES) != null)
            strings.add(weightliftingSet.get(WeightliftingKey.NOTES).toJson());
        if(weightliftingSet.get(WeightliftingKey.PERCENTAGE) != null)
            strings.add(weightliftingSet.get(WeightliftingKey.PERCENTAGE).toJson());
        Gson gson = new Gson();
        return gson.toJson(strings);
    }

    private static Map<WeightliftingKey, WeightliftingParameter> stringToWeightliftingSet(String string){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();
        List<String> stringList = gson.fromJson(string, listType);
        Map<WeightliftingKey, WeightliftingParameter> map = new HashMap<>();
        for(String stringElement : stringList) {
            if(stringElement.contains(WeightliftingKey.WEIGHT.name())) {
                Weight weight = gson.fromJson(stringElement, Weight.class);
                map.put(WeightliftingKey.WEIGHT, weight);
            }
            if(stringElement.contains(WeightliftingKey.REPS.name())) {
                Reps reps = gson.fromJson(stringElement, Reps.class);
                map.put(WeightliftingKey.REPS, reps);
            }
            if(stringElement.contains(WeightliftingKey.RPE.name())) {
                Rpe rpe = gson.fromJson(stringElement, Rpe.class);
                map.put(WeightliftingKey.RPE, rpe);
            }
            if(stringElement.contains(WeightliftingKey.BUFFER.name())) {
                Buffer buffer = gson.fromJson(stringElement, Buffer.class);
                map.put(WeightliftingKey.BUFFER, buffer);
            }
            if(stringElement.contains(WeightliftingKey.PAUSE.name())) {
                Pause pause = gson.fromJson(stringElement, Pause.class);
                map.put(WeightliftingKey.PAUSE, pause);
            }
            if(stringElement.contains(WeightliftingKey.NOTES.name())) {
                Notes notes = gson.fromJson(stringElement, Notes.class);
                map.put(WeightliftingKey.NOTES, notes);
            }
            if(stringElement.contains(WeightliftingKey.PERCENTAGE.name())) {
                Percentage percentage = gson.fromJson(stringElement, Percentage.class);
                map.put(WeightliftingKey.PERCENTAGE, percentage);
            }
        }
        return map;
    }

    private static String cardioSetToString(CardioSet cardioSet) throws JSONException {
        List<String> strings = new ArrayList<>();
        if(cardioSet.get(CardioKey.DURATION) != null)
            strings.add(cardioSet.get(CardioKey.DURATION).toJson());
        if(cardioSet.get(CardioKey.GOAL) != null)
            strings.add(cardioSet.get(CardioKey.GOAL).toJson());
        if(cardioSet.get(CardioKey.LAST_PERFORMANCE) != null)
            strings.add(cardioSet.get(CardioKey.LAST_PERFORMANCE).toJson());
        Gson gson = new Gson();
        return gson.toJson(strings);
    }

    private static Map<CardioKey, CardioParameter> stringToCardioSet(String string){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();
        List<String> stringList = gson.fromJson(string, listType);
        Map<CardioKey, CardioParameter> map = new HashMap<>();
        for(String stringElement : stringList) {
            if(stringElement.contains(CardioKey.DURATION.name())) {
                Duration duration = gson.fromJson(stringElement, Duration.class);
                map.put(CardioKey.DURATION, duration);
            }
            if(stringElement.contains(CardioKey.GOAL.name())) {
                Goal goal = gson.fromJson(stringElement, Goal.class);
                map.put(CardioKey.GOAL, goal);
            }
            if(stringElement.contains(CardioKey.LAST_PERFORMANCE.name())) {
                LastPerformance lastPerformance = gson.fromJson(stringElement, LastPerformance.class);
                map.put(CardioKey.LAST_PERFORMANCE, lastPerformance);
            }
        }
        return map;
    }
}
