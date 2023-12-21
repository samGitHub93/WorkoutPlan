package it.sam.workoutplan.model.parameter;

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
}
