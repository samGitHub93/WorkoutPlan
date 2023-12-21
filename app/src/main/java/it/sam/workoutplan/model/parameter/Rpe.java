package it.sam.workoutplan.model.parameter;

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
}
