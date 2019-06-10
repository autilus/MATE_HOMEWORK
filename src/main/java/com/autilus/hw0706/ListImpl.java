package com.autilus.hw0706;

public class ListImpl<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int size;
    private int position;

    private void checkCapasity(int i) {
        if (i >= size) {
            size += DEFAULT_CAPACITY / 2;
            array = copyToNewArray(array);
        }
    }

    private Object[] copyToNewArray(Object[] newArray) {
        newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, position);
        return newArray;
    }

    @Override
    public void add(Object value) {
        checkCapasity(position);
        add(value, position);
        position++;
    }

    @Override
    public void add(Object value, int index) {
        checkCapasity(index);
        array[index] = value;
    }

    @Override
    public void addAll(List list) {
        Object[] obj = list.toArray();
        size = obj.length;
        array = copyToNewArray(array);
        System.arraycopy(obj, 0, this.array, 0, obj.length);
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public void set(T value, int index) {
        array[index] = value;
    }

    @Override
    public T remove(int index) {
        size -= 1;
        for (int j = index; j < size; j++) {
            array[j] = array[j + 1];
        }
        return (T) array;    }

    public T remove(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i] == t) {
                return remove(i);
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
        return array[0] == null;
    }

    @Override
    public Object[] toArray() {
        return array;
    }
}
