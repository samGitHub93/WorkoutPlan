package it.sam.workoutplan.model.parameter;

import org.json.JSONException;

import it.sam.workoutplan.enumerator.Category;

public interface Parameter {

    String getName();

    String getValue();

    void setValue(String value);

    Category getCategory();

    String toJson() throws JSONException;
}
