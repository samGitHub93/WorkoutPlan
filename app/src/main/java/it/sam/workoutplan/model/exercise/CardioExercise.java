package it.sam.workoutplan.model.exercise;

import it.sam.workoutplan.enumerator.Category;
import it.sam.workoutplan.model.set.CardioSet;

public class CardioExercise implements Exercise {

    private String name;
    private CardioSet cardioSet;
    private final Category category = Category.CARDIO;
    private String genericNotes;

    public CardioExercise() {}

    public CardioExercise(String name, CardioSet cardioSet, String genericNotes) {
        this.name = name;
        this.cardioSet = cardioSet;
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

    public CardioSet getCardioSet() {
        return cardioSet;
    }

    public void setCardioSet(CardioSet cardioSet) {
        this.cardioSet = cardioSet;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String getGenericNotes() {
        return genericNotes;
    }

    @Override
    public void setGenericNotes(String genericNotes) {
        this.genericNotes = genericNotes;
    }
}
