package com.autilus.hw1106;

import java.util.Arrays;

public class HashMapImpl<V, K> implements HashMap<V, K> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int size = 0;
    private float loading = 0.0f;
    private Node<V, K>[] nodes;

    private void increaseSize(V value, K key, Node<V, K>[] nodes) {
        loading = 0;
        size = 0;
        Node<V, K>[] increaseNodes = new Node[nodes.length << 1];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                Node<V, K> node = nodes[i];
                if (node.getNext() == null) {
                    putNode(node.getValue(), node.getKey(), increaseNodes);
                } else {
                    while (node.getNext() != null) {
                        putNode(node.getValue(), node.getKey(), increaseNodes);
                        node = node.getNext();
                    }
                }
            }
        }
        nodes = increaseNodes;
    }

    private void putNode(V value, K key, Node<V, K>[] nodes) {
        int index = (nodes.length - 1) & hash(key);
        if (key == null) { key=(K)"0"; }
        Node<V, K> node = new Node<>(null, key, value, hash(key));
        if (nodes[index] == null) {
            nodes[index] = node;
            loading += (float) 1 / (nodes.length - 1);
        } else {
            if (key.equals(nodes[index].getKey())) {
                nodes[index].setValue(value);
            } else {
                Node<V, K> basketNode = nodes[index];
                while (basketNode.getNext() != null) {
                    basketNode = basketNode.next;
                    if (value.equals(nodes[index].value) && hash(key) == nodes[index].getHash()) {
                        nodes[index].setValue(value);
                        return;
                    }
                }
                basketNode.setNext(node);
            }
        }
        size++;
    }

    private Node<V, K> getNode(K key) {
        Node<V, K> node = nodes[(nodes.length - 1) & hash(key)];
        if (node.getKey().equals(key)) {
            return node;
        } else {
            while (node.getNext() != null) {
                node = node.getNext();
                if (node.getKey().equals(key)) {
                    return node;
                }
            }
        }
        return null;
    }

    @Override
    public void put(V value, K key) {
        if (nodes == null) {
            nodes = new Node[INITIAL_CAPACITY];
        } else if (loading > LOAD_FACTOR) {
            increaseSize(value, key, nodes);
        }
        putNode(value, key, nodes);
    }

    @Override
    public V get(K key) {
        try {
            return getNode(key).getValue();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public void clean() {
        nodes = null;
        size = 0;
        loading = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int hash(K key) {
        if (key == null) {
            return 0;
        } else {
            return key.hashCode() ^ (key.hashCode() >>> 16);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashMapImpl<?, ?> hashMap = (HashMapImpl<?, ?>) o;

        if (size != hashMap.size) return false;
        if (Float.compare(hashMap.loading, loading) != 0) return false;
        return Arrays.equals(nodes, hashMap.nodes);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + (loading != +0.0f ? Float.floatToIntBits(loading) : 0);
        result = 31 * result + Arrays.hashCode(nodes);
        return result;
    }

    private static class Node<V, K> {
        private Node<V, K> next;
        private K key;
        private V value;
        private final int hash;

        public Node(Node<V, K> next, K key, V value, int hash) {
            this.next = next;
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        public Node<V, K> getNext() {
            return next;
        }

        public void setNext(Node<V, K> next) {
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getHash() {
            return hash;
        }
    }
}
