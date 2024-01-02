package it.sam.workoutplan.model.parameter;

import org.json.JSONException;
import org.json.JSONObject;

public class Reps implements WeightliftingParameter {
    private static final String NAME = "REPS";
    private String value;

    public Reps(String value) {
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

    @Override
    public String toJson() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("name", NAME);
        jo.put("value", value);
        return jo.toString();
    }
}
