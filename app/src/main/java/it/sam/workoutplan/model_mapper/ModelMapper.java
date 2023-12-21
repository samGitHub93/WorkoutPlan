package it.sam.workoutplan.model_mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.sam.workoutplan.database.model.RoomExercise;
import it.sam.workoutplan.database.model.RoomExerciseDay;
import it.sam.workoutplan.enumerator.BodyPart;
import it.sam.workoutplan.enumerator.Category;
import it.sam.workoutplan.enumerator.ProgressionKeys;
import it.sam.workoutplan.model.exercise.CardioExercise;
import it.sam.workoutplan.model.exercise.WeightliftingExercise;
import it.sam.workoutplan.model.exercise.Exercise;
import it.sam.workoutplan.model.ExerciseDay;
import it.sam.workoutplan.model.exercise.StretchExercise;

public class ModelMapper {

    public static RoomExerciseDay toRoomExerciseDay(ExerciseDay exerciseDay) throws Exception {
        RoomExerciseDay roomExerciseDay = new RoomExerciseDay();
        List<RoomExercise> roomExercises = new ArrayList<>();
        for(Exercise exercise : exerciseDay.getExercises()){
            RoomExercise roomExercise = toRoomExercise(exercise);
            roomExercises.add(roomExercise);
        }
        roomExerciseDay.setExercises(roomExercises);
        return roomExerciseDay;
    }

    public static ExerciseDay toModelExerciseDay(RoomExerciseDay roomExerciseDay) throws Exception {
        ExerciseDay exerciseDay = new ExerciseDay();
        List<Exercise> exercises = new ArrayList<>();
        for(RoomExercise roomExercise : roomExerciseDay.getExercises()){
            Exercise exercise = toModelExercise(roomExercise);
            exercises.add(exercise);
        }
        exerciseDay.setExercises(exercises);
        return exerciseDay;
    }

    private static RoomExercise toRoomExercise(Exercise exercise) throws Exception {
        if(exercise instanceof WeightliftingExercise){
            WeightliftingExercise weightliftingExercise = (WeightliftingExercise) exercise;
            return fromWeightliftingExerciseToRoomExercise(weightliftingExercise);
        } else if (exercise instanceof CardioExercise) {
            CardioExercise cardioExercise = (CardioExercise) exercise;
            return fromCardioExerciseToRoomExercise(cardioExercise);
        } else if(exercise instanceof StretchExercise) {
            StretchExercise stretchExercise = (StretchExercise) exercise;
            return fromStretchExerciseToRoomExercise(stretchExercise);
        } else throw new Exception();
    }

    private static Exercise toModelExercise(RoomExercise roomExercise) throws Exception {
        if(roomExercise.getCategory() == Category.WEIGHTLIFTING){
            return fromRoomExerciseToWeightliftingExercise(roomExercise);
        } else if(roomExercise.getCategory() == Category.CARDIO){
            return fromRoomExerciseToCardioExercise(roomExercise);
        } else if(roomExercise.getCategory() == Category.STRETCH){
            return fromRoomExerciseToStretchExercise(roomExercise);
        } else throw new Exception();
    }

    private static RoomExercise fromWeightliftingExerciseToRoomExercise(WeightliftingExercise weightliftingExercise){
        RoomExercise roomExercise = new RoomExercise();
        roomExercise.setName(weightliftingExercise.getName());
        roomExercise.setCategory(Category.WEIGHTLIFTING);
        roomExercise.setWeightliftingSets(weightliftingExercise.getWeightliftingSets());
        roomExercise.setBodyParts(weightliftingExercise.getBodyParts());
        roomExercise.setGenericNotes(weightliftingExercise.getGenericNotes());
        return roomExercise;
    }

    private static RoomExercise fromCardioExerciseToRoomExercise(CardioExercise cardioExercise){
        RoomExercise roomExercise = new RoomExercise();
        roomExercise.setName(cardioExercise.getName());
        roomExercise.setCategory(Category.CARDIO);
        roomExercise.setCardioSets(cardioExercise.getCardioSet());
        roomExercise.setGenericNotes(cardioExercise.getGenericNotes());
        return roomExercise;
    }

    private static RoomExercise fromStretchExerciseToRoomExercise(StretchExercise stretchExercise){
        RoomExercise roomExercise = new RoomExercise();
        roomExercise.setName(stretchExercise.getName());
        roomExercise.setCategory(Category.STRETCH);
        roomExercise.setBodyParts(stretchExercise.getBodyParts());
        roomExercise.setGenericNotes(stretchExercise.getGenericNotes());
        return roomExercise;
    }

    private static WeightliftingExercise fromRoomExerciseToWeightliftingExercise(RoomExercise roomExercise){
        WeightliftingExercise weightliftingExercise = new WeightliftingExercise();
        weightliftingExercise.setName(roomExercise.getName());
        weightliftingExercise.setWeightliftingSets(roomExercise.getWeightliftingSets());
        weightliftingExercise.setBodyParts(roomExercise.getBodyParts());
        weightliftingExercise.setGenericNotes(roomExercise.getGenericNotes());
        return weightliftingExercise;
    }

    private static CardioExercise fromRoomExerciseToCardioExercise(RoomExercise roomExercise){
        CardioExercise cardioExercise = new CardioExercise();
        cardioExercise.setName(roomExercise.getName());
        cardioExercise.setCardioSet(roomExercise.getCardioSets());
        cardioExercise.setGenericNotes(roomExercise.getGenericNotes());
        return cardioExercise;
    }

    private static StretchExercise fromRoomExerciseToStretchExercise(RoomExercise roomExercise){
        StretchExercise stretchExercise = new StretchExercise();
        stretchExercise.setName(roomExercise.getName());
        stretchExercise.setBodyParts(roomExercise.getBodyParts());
        stretchExercise.setGenericNotes(roomExercise.getGenericNotes());
        return stretchExercise;
    }

    private static String manageProgression(Map<ProgressionKeys, String> progression){
        String weightString = progression.get(ProgressionKeys.WEIGHT);
        String weeksString = progression.get(ProgressionKeys.WEEKS);
        String setsString = progression.get(ProgressionKeys.REPS);
        return "WEIGHT=" + weightString + "@WEEKS=" + weeksString + "@SETS=" + setsString;
    }

    private static Map<ProgressionKeys, String> manageProgression(String progression){
        String[] splitString = progression.split("@");
        String weightString = splitString[0].substring(splitString[0].indexOf("=") + 1);
        String weeksString = splitString[1].substring(splitString[1].indexOf("=") + 1);
        String setsString = splitString[2].substring(splitString[2].indexOf("=") + 1);
        Map<ProgressionKeys, String> progressionMap = new HashMap<>();
        progressionMap.put(ProgressionKeys.WEIGHT, weightString);
        progressionMap.put(ProgressionKeys.WEEKS, weeksString);
        progressionMap.put(ProgressionKeys.REPS, setsString);
        return progressionMap;
    }

    private static String manageCategories(List<BodyPart> categories){
        StringBuilder categoriesStringBuilder = new StringBuilder();
        for(BodyPart bodyPart : categories){
            categoriesStringBuilder.append(bodyPart.name()).append("@");
        }
        String categoriesString = categoriesStringBuilder.toString();
        return categoriesString.substring(0, categoriesString.length() - 1);
    }

    private static List<BodyPart> manageCategories(String categories){
        List<BodyPart> bodyPartList = new ArrayList<>();
        String[] splitString = categories.split("@");
        for(String category : splitString){
            bodyPartList.add(BodyPart.valueOf(category));
        }
        return bodyPartList;
    }
}
