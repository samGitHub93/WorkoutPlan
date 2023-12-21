package it.sam.workoutplan.model.parameter;

public class Notes implements WeightliftingParameter {
    private static final String NAME = "NOTES";
    private String value;

    public Notes(String value) {
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
