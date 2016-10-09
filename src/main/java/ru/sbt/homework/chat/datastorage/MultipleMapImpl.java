package ru.sbt.homework.chat.datastorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 08.10.2016.
 */
public class MultipleMapImpl<K, V> implements MultipleMap<K, V>{

    private Map<K, List<V>> Vs = new HashMap<>();

    @Override
    public void put(K key, V value) {
        List<V> Vs = get(key);
        if (Vs == null) {
            Vs = new ArrayList<>();
            this.Vs.put(key, Vs);
        }
        Vs.add(value);
    }

    @Override
    public List<V> get(K key) {
        return Vs.get(key);
    }

    @Override
    public List<V> getAll() {
        List<V> result = new ArrayList<V>();
        for (List<V> item : Vs.values()) {
            result.addAll(item);
        }
        return result;
    }
}
