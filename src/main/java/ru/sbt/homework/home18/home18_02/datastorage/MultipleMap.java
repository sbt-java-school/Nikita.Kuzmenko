package ru.sbt.homework.home18.home18_02.datastorage;

import java.util.List;

/**
 * Интерфейс для хранения данных
 */
public interface MultipleMap<K, V> {
    void put(K key, V value);

    void delAll();

    void del(K key);

    List<V> get(K key);

    List<V> getAll();
}
