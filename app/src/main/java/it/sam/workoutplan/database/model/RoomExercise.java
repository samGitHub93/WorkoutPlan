package it.sam.workoutplan.database.model;

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

    public RoomExercise(String name, List<WeightliftingSet> weightliftingSets, List<BodyPart> bodyParts, Category category, String genericNotes) {
        this.name = name;
        this.sets = Converter.fromWeightliftingSetsToString(weightliftingSets);
        this.bodyParts = Converter.fromBodyPartsToString(bodyParts);
        this.category = category.name();
        this.genericNotes = genericNotes;
    }

    public RoomExercise(String name, CardioSet cardioSet, List<BodyPart> bodyParts, Category category, String genericNotes) {
        this.name = name;
        this.sets = Converter.fromCardioSetToString(cardioSet);
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

    public void setWeightliftingSets(List<WeightliftingSet> weightliftingSets) {
        this.sets = Converter.fromWeightliftingSetsToString(weightliftingSets);
    }

    public CardioSet getCardioSets() {
        return Converter.fromStringToCardioSet(sets);
    }

    public void setCardioSets(CardioSet cardioSets) {
        this.sets = Converter.fromCardioSetToString(cardioSets);
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