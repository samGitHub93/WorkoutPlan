package it.sam.workoutplan.model.parameter;

import org.json.JSONException;
import org.json.JSONObject;

public class Rpe implements WeightliftingParameter {
    private static final String NAME = "RPE";
    private static final String UNIT_OF_MEASURE = "@";
    private String value;

    public Rpe(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    public String getValuePlusUnitOfMeasure() {
        String valuePlusUnitOfMeasure = UNIT_OF_MEASURE + " " + value;
        return valuePlusUnitOfMeasure.trim();
    }

    @Override
    public String toJson() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("name", NAME);
        jo.put("unitOfMeasure", UNIT_OF_MEASURE);
        jo.put("value", value);
        return jo.toString();
    }
}
