package com.autilus.hw0706;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ListImpl<T> implements List<T> {
    private int INITIAL_SIZE = 10;
    private T[] values = (T[]) new Object[INITIAL_SIZE];
    private int size = 0;

    private void increaseArray() {
        values = Arrays.copyOf(values, (values.length * 3) / 2);
    }

    private void checkIndexSize(int index) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void add(T value) {
        if (size == values.length) {
            increaseArray();
        }
        values[size++] = value;
    }

    @Override
    public void add(int index, T value) {
        if (size == index) {
            add(value);
            return;
        } else {
            checkIndexSize(index);
        }
        if (size == values.length) {
            increaseArray();
        }
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        if (values.length < size + list.size()) {
            values = Arrays.copyOf(values, size + list.size());
        }
        for (int i = 0; i < list.size(); i++) {
            values[size++] = list.get(i);
        }
    }

    @Override
    public T get(int index) {
        checkIndexSize(index + 1);
        return values[index];
    }

    @Override
    public void set(int index, T value) {
        checkIndexSize(index);
        values[index] = value;
    }

    @Override
    public T remove(int index) {
        checkIndexSize(index);
        T result = values[index];
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        values = Arrays.copyOf(values, size);
        return result;
    }

    @Override
    public T remove(T value) {
        for (int index = 0; index < values.length; index++) {
            if (values[index] == value) {
                remove(index);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return values;
    }

    @Override
    public String toString() {
        return "ListImpl{" +
                "INITIAL_SIZE=" + INITIAL_SIZE +
                ", values=" + Arrays.toString(values) +
                ", size=" + size +
                '}';
    }
}
