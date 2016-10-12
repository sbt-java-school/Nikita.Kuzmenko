package ru.sbt.homework.home18.home18_02.datastorage;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Класс, реализующий интерфейс мультимапы.
 */
public class MultipleMapImpl<K, V> implements MultipleMap<K, V> {

    //Используем ConcurrentHashMap для happens before (вторая команда будет «в курсе» изменений, проведённых первой).
    private Map<K, List<V>> Vs = new ConcurrentHashMap<>();


    //Использован потокобезопасный вариант коллекции ArrayList (CopyOnWriteArrayList)
    @Override
    public void put(K key, V value) {
        List<V> Vs = get(key);
        if (Vs == null) {
            Vs = new CopyOnWriteArrayList<V>();
            this.Vs.put(key, Vs);
        }
        Vs.add(value);
    }

    //Удаление всех сообщений
    @Override
    public void delAll() {
        Iterator<Map.Entry<K, List<V>>> multipleMapIterator = this.Vs.entrySet().iterator();
        while (multipleMapIterator.hasNext()){
            this.Vs.remove(multipleMapIterator.next());
        }
    }

    //Удаление всех сообщений по ключу (получатель)
    @Override
    public void del(K key) {
        this.Vs.remove(key);
    }


    //Получение сообщений по ключу (получатель)
    @Override
    public List<V> get(K key) {
        return Vs.get(key);
    }

    //Получение всех сообщений
    @Override
    public List<V> getAll() {
        List<V> result = new CopyOnWriteArrayList<V>();
        for (List<V> item : Vs.values()) {
            result.addAll(item);
        }
        return result;
    }
}
