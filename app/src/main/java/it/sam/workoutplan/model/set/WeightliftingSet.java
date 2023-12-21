package it.sam.workoutplan.model.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import it.sam.workoutplan.enumerator.Category;
import it.sam.workoutplan.enumerator.WeightliftingKey;
import it.sam.workoutplan.model.parameter.WeightliftingParameter;

public class WeightliftingSet implements WorkoutSet<WeightliftingKey, WeightliftingParameter> {

    private Map<WeightliftingKey, WeightliftingParameter> weightliftingParameters = new HashMap<>();

    public WeightliftingSet() {}

    public WeightliftingSet(Map<WeightliftingKey, WeightliftingParameter> weightliftingParameters) {
        this.weightliftingParameters = weightliftingParameters;
    }

    public Map<WeightliftingKey, WeightliftingParameter> getWeightliftingParameters() {
        return weightliftingParameters;
    }

    @Override
    public int size() {
        return weightliftingParameters.size();
    }

    @Override
    public boolean isEmpty() {
        return weightliftingParameters.isEmpty();
    }

    @Override
    public WeightliftingParameter get(WeightliftingKey key) {
        return weightliftingParameters.get(key);
    }

    @Override
    public void put(WeightliftingKey key, WeightliftingParameter value) {
        weightliftingParameters.put(key, value);
    }

    @Override
    public void remove(WeightliftingKey key) {
        weightliftingParameters.remove(key);
    }

    @Override
    public void putAll(Map<WeightliftingKey, WeightliftingParameter> map) {
        weightliftingParameters.putAll(map);
    }

    @Override
    public void clear() {
        weightliftingParameters.clear();
    }

    @Override
    public Category getCategory() {
        return Category.WEIGHTLIFTING;
    }

    @Override
    public Collection<WeightliftingParameter> getValues() {
        return weightliftingParameters.values();
    }

}
