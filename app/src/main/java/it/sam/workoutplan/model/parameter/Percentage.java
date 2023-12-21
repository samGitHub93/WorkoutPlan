package it.sam.workoutplan.model.parameter;

public class Percentage implements WeightliftingParameter {
    private static final String NAME = "PERCENTAGE";
    private static final String UNIT_OF_MEASURE = "%";
    private String value;

    public Percentage(String value) {
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
