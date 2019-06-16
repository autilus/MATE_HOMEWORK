package com.autilus.hw1106;

public interface HashMap<V, K> {
    public void put(V value, K key);

    public V get(K key);

    public void clean();

    public boolean isEmpty();

    public int size();

    public int hash(K key);
}
