package it.sam.workoutplan.database.model;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import it.sam.workoutplan.enumerator.BodyPart;
import it.sam.workoutplan.enumerator.Category;
import it.sam.workoutplan.model.set.CardioSet;
import it.sam.workoutplan.model.set.WeightliftingSet;

public class RoomExercise {
    private String name;
    private String sets;
    private String bodyParts;
    private String category;
    private String genericNotes;

    public RoomExercise() {}

    public RoomExercise(String name, List<WeightliftingSet> weightliftingSets, List<BodyPart> bodyParts, Category category, String genericNotes) throws JSONException {
        this.name = name;
        this.sets = Converter.fromWeightliftingSetsToString(weightliftingSets);
        this.bodyParts = Converter.fromBodyPartsToString(bodyParts);
        this.category = category.name();
        this.genericNotes = genericNotes;
    }

    public RoomExercise(String name, CardioSet cardioSet, List<BodyPart> bodyParts, Category category, String genericNotes) throws JSONException {
        this.name = name;
        this.sets = Converter.fromCardioSetsToString(new ArrayList<>(Collections.singletonList(cardioSet)));
        this.bodyParts = Converter.fromBodyPartsToString(bodyParts);
        this.category = category.name();
        this.genericNotes = genericNotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenericNotes() {
        return genericNotes;
    }

    public void setGenericNotes(String genericNotes) {
        this.genericNotes = genericNotes;
    }

    public List<WeightliftingSet> getWeightliftingSets() {
        return Converter.fromStringToWeightliftingSets(sets);
    }

    public void setWeightliftingSets(List<WeightliftingSet> weightliftingSets) throws JSONException {
        this.sets = Converter.fromWeightliftingSetsToString(weightliftingSets);
    }

    public CardioSet getCardioSets() {
        return Converter.fromStringToCardioSets(sets).get(0);
    }

    public void setCardioSets(CardioSet cardioSet) throws JSONException {
        this.sets = Converter.fromCardioSetsToString(new ArrayList<>(Collections.singletonList(cardioSet)));
    }

    public List<BodyPart> getBodyParts() {
        return Converter.fromStringToBodyParts(bodyParts);
    }

    public void setBodyParts(List<BodyPart> categories) {
        this.bodyParts = Converter.fromBodyPartsToString(categories);
    }

    public Category getCategory() {
        return Converter.fromStringToCategory(category);
    }

    public void setCategory(Category category) {
        this.category = category.name();
    }
}
