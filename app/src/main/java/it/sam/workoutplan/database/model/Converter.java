package it.sam.workoutplan.database.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import it.sam.workoutplan.enumerator.BodyPart;
import it.sam.workoutplan.enumerator.Category;
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
        Type listType = new TypeToken<List<WeightliftingSet>>(){}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromWeightliftingSetsToString(List<WeightliftingSet> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    public static CardioSet fromStringToCardioSet(String value) {
        Type listType = new TypeToken<CardioSet>(){}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromCardioSetToString(CardioSet cardioSet) {
        Gson gson = new Gson();
        return gson.toJson(cardioSet);
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
}
