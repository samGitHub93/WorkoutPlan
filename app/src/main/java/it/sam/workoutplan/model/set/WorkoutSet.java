package it.sam.workoutplan.model.set;

import java.util.Collection;
import java.util.Map;

import it.sam.workoutplan.enumerator.Category;

public interface WorkoutSet<K, V> {

    int size();

    boolean isEmpty();

    V get(K key);

    void put(K key, V value);

    void remove(K key);

    void putAll(Map<K, V> map);

    void clear();

    Category getCategory();

    Collection<V> getValues();
}
