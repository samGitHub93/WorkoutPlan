package it.sam.workoutplan.model.parameter;

public class Buffer implements WeightliftingParameter {
    private static final String NAME = "BUFFER";
    private String value;

    public Buffer(String value) {
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
}
