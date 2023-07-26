package it.sam.workoutplan.model;

import java.util.Map;

import it.sam.workoutplan.enumerator.Category;

public class AnaerobicExercise extends Exercise {

    private int set;
    private String reps;
    private String buffer;
    private String weight;
    private Map<String, String> progression;
    private Category category;

    public AnaerobicExercise() {}

    public AnaerobicExercise(int set, String reps, String buffer, String weight, Map<String, String> progression, Category category) {
        this.set = set;
        this.reps = reps;
        this.buffer = buffer;
        this.weight = weight;
        this.progression = progression;
        this.category = category;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Map<String, String> getProgression() {
        return progression;
    }

    public void setProgression(String weight, String weeks) {
        this.progression.put(weight, weeks);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
