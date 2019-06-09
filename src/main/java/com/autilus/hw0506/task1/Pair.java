package com.autilus.hw0506.task1;

import java.util.Objects;

class Pair<T, V> {
    private T t;
    private V v;

    private Pair(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public T getFirst() {
        return t;
    }

    public V getSecond() {
        return v;
    }

    public static <T, V> Pair of(T t, V v) {
        return new Pair<>(t, v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(t, pair.t) &&
                Objects.equals(v, pair.v);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, v);
    }
}
