package ru.sbt.homework.chat.datastorage;

import java.util.List;

/**
 * Created by Admin on 08.10.2016.
 */
public interface MultipleMap<K, V> {
    void put(K key, V value);

    List<V> get(K key);

    List<V> getAll();
}
