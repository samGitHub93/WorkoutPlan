package it.sam.workoutplan.model.parameter;

import org.json.JSONException;
import org.json.JSONObject;

public class LastPerformance implements CardioParameter {
    private static final String NAME = "LAST_PERFORMANCE";
    private String unitOfMeasure;
    private String value;

    public LastPerformance(String value) {
        this.value = value;
    }

    public LastPerformance(String unitOfMeasure, String value) {
        this.unitOfMeasure = unitOfMeasure;
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

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getValuePlusUnitOfMeasure() {
        String valuePlusUnitOfMeasure = value + " " + unitOfMeasure;
        return valuePlusUnitOfMeasure.trim();
    }

    @Override
    public String toJson() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("name", NAME);
        jo.put("unitOfMeasure", unitOfMeasure);
        jo.put("value", value);
        return jo.toString();
    }
}
