package com.autilus.hw0706;

public class ListImpl<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int size;
    private int position;

    private void checkCapasity(int index) {
        if (index >= size) {
            size += size >> 1;
            array = copyToNewArray(array);
        }
    }

    private Object[] copyToNewArray(Object[] newArray) {
        newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, position);
        return newArray;
    }

    @Override
    public void add(T value) {
        checkCapasity(position);
        add(value, position);
        position++;
    }

    @Override
    public void add(T value, int index) {
        checkCapasity(index);
        array = copyToNewArray(array);
        System.arraycopy(array, index, array, index + 1, size - index - 1);
        array[index] = value;
    }

    @Override
    public void addAll(List list) {
        Object[] objects = list.toArray();
        size = objects.length;
        array = copyToNewArray(array);
        System.arraycopy(objects, 0, array, 0, objects.length);
        position += size;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    @Override
    public void set(T value, int index) {
        checkIndex(index);
        array[index] = value;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("can't set nonexistent index -- " + index);
        }
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        size--;
        System.arraycopy(array, index, array, index - 1, size - index - 1);
        return (T) array;
    }

    public T remove(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) {
                return remove(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return array.length;
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
