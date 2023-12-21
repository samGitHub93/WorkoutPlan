package it.sam.workoutplan.model.exercise;

import it.sam.workoutplan.enumerator.Category;

public interface Exercise {
    String getName();
    void setName(String name);
    String getGenericNotes();
    void setGenericNotes(String genericNotes);
    Category getCategory();
}
