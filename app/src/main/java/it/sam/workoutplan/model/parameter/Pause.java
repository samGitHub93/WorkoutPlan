package it.sam.workoutplan.model.parameter;

public class Pause implements WeightliftingParameter {
    private static final String NAME = "PAUSE";
    private static final String UNIT_OF_MEASURE = "min";
    private String value;

    public Pause(String value) {
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
        String valuePlusUnitOfMeasure = value + " " + UNIT_OF_MEASURE;
        return valuePlusUnitOfMeasure.trim();
    }
}
