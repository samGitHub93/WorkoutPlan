package it.sam.workoutplan.model.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import it.sam.workoutplan.enumerator.CardioKey;
import it.sam.workoutplan.enumerator.Category;
import it.sam.workoutplan.model.parameter.CardioParameter;

public class CardioSet implements WorkoutSet<CardioKey, CardioParameter> {

    private Map<CardioKey, CardioParameter> cardioParameters = new HashMap<>();

    public CardioSet() {}

    public CardioSet(Map<CardioKey, CardioParameter> cardioParameters) {
        this.cardioParameters = cardioParameters;
    }

    public Map<CardioKey, CardioParameter> getCardioParameters() {
        return cardioParameters;
    }

    @Override
    public int size() {
        return cardioParameters.size();
    }

    @Override
    public boolean isEmpty() {
        return cardioParameters.isEmpty();
    }

    @Override
    public CardioParameter get(CardioKey key) {
        return cardioParameters.get(key);
    }

    @Override
    public void put(CardioKey key, CardioParameter value) {
        cardioParameters.put(key, value);
    }

    @Override
    public void remove(CardioKey key) {
        cardioParameters.remove(key);
    }

    @Override
    public void putAll(Map<CardioKey, CardioParameter> map) {
        cardioParameters.putAll(map);
    }

    @Override
    public void clear() {
        cardioParameters.clear();
    }

    @Override
    public Category getCategory() {
        return Category.CARDIO;
    }

    @Override
    public Collection<CardioParameter> getValues() {
        return cardioParameters.values();
    }
}
