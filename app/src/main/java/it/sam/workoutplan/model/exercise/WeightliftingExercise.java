package it.sam.workoutplan.model.exercise;

import java.util.List;

import it.sam.workoutplan.enumerator.BodyPart;
import it.sam.workoutplan.enumerator.Category;
import it.sam.workoutplan.model.set.WeightliftingSet;

public class WeightliftingExercise implements Exercise {

    private String name;
    private List<WeightliftingSet> weightliftingSets;
    private List<BodyPart> bodyParts;
    private final Category category = Category.WEIGHTLIFTING;
    private String genericNotes;

    public WeightliftingExercise() {}

    public WeightliftingExercise(String name, List<WeightliftingSet> weightliftingSets, List<BodyPart> bodyParts, String genericNotes) {
        this.name = name;
        this.weightliftingSets = weightliftingSets;
        this.bodyParts = bodyParts;
        this.genericNotes = genericNotes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public List<WeightliftingSet> getWeightliftingSets() {
        return weightliftingSets;
    }

    public void setWeightliftingSets(List<WeightliftingSet> weightliftingSets) {
        this.weightliftingSets = weightliftingSets;
    }

    public List<BodyPart> getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(List<BodyPart> bodyParts) {
        this.bodyParts = bodyParts;
    }

    @Override
    public String getGenericNotes() {
        return genericNotes;
    }

    @Override
    public void setGenericNotes(String genericNotes) {
        this.genericNotes = genericNotes;
    }

    @Override
    public Category getCategory() {
        return category;
    }
}
