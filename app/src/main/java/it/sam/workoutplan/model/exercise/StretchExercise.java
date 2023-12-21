package it.sam.workoutplan.model.exercise;

import java.util.List;

import it.sam.workoutplan.enumerator.BodyPart;
import it.sam.workoutplan.enumerator.Category;

public class StretchExercise implements Exercise {

    private String name;
    private List<BodyPart> bodyParts;
    private final Category category = Category.STRETCH;
    private String genericNotes;

    public StretchExercise() {}

    public StretchExercise(String name, List<BodyPart> bodyParts, String genericNotes) {
        this.name = name;
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

    public List<BodyPart> getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(List<BodyPart> bodyParts) {
        this.bodyParts = bodyParts;
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
