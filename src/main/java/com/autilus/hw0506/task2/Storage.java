package com.autilus.hw0506.task2;

import java.util.Arrays;

public class Storage<K, V> {
    private static final int ARRAY_INDEX = 5;
    private K[] keyArray;
    private V[] valueArray;
    private int count = 0;

    public Storage() {
        this.keyArray = (K[]) new Object[ARRAY_INDEX];
        this.valueArray = (V[]) new Object[ARRAY_INDEX];
    }

    public void put(K key, V value) {
        this.keyArray[count] = key;
        this.valueArray[count] = value;
        count++;
    }

    public V get(K key) {
        V result = null;
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == key) {
                result = valueArray[i];
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "keyArray=" + Arrays.toString(keyArray) +
                ", valueArray=" + Arrays.toString(valueArray) +
                '}';
    }
}

