package it.sam.workoutplan.model.parameter;

public class Goal implements CardioParameter {
    private static final String NAME = "GOAL";
    private String unitOfMeasure;
    private String value;

    public Goal(String value) {
        this.value = value;
    }

    public Goal(String unitOfMeasure, String value) {
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
}
