package com.autilus.hw0706;

public interface List<T> {
    void add(T value);

    void add(int index, T value);

    void addAll(List<T> list);

    T get(int index);

    void set(int index, T value);

    T remove(int index);

    T remove(T t);

    int size();

    boolean isEmpty();

    Object[] toArray();
}
