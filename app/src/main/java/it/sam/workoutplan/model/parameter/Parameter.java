package it.sam.workoutplan.model.parameter;

import it.sam.workoutplan.enumerator.Category;

public interface Parameter {

    String getName();

    String getValue();

    void setValue(String value);

    Category getCategory();
}
