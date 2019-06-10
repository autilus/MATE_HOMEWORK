package com.autilus.hw1006;

public class Node<T> {
    T item;
    Node<T> next;
    Node<T> prev;

    public Node(T item) {
        this.item = item;
    }
}