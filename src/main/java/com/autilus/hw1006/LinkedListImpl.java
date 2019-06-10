package com.autilus.hw1006;

public class LinkedListImpl<T> implements List<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    private boolean isCorrectIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("index incorrect " + index);
        }
        return true;
    }

    private Node<T> currentNode(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void add(T t) {
        Node<T> newNode = new Node<>(t);
        if (isEmpty()) {
            newNode.next = null;
            newNode.prev = null;
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(T t, int index) {
        Node<T> newNode = new Node<>(t);
        if (index == 0) {
            add(t);
        }
        if (index == size) {
            last.next = newNode;
            last = newNode;
        }
        Node<T> left = currentNode(index);
        Node<T> right = left.prev;
        left.next = newNode;
        right.prev = newNode;
        newNode.next = right;
        newNode.prev = left;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        if (isCorrectIndex(index)) {
            return currentNode(index).item;
        }
        return null;
    }


    @Override
    public void set(T t, int index) {
        if (isCorrectIndex(index)) {
            currentNode(index).item = t;
        }
    }

    @Override
    public T remove(int index) {
        if (!isEmpty() && isCorrectIndex(index)) {
            Node<T> toBeRemoved = currentNode(index);
            T t = toBeRemoved.item;
            if (toBeRemoved == last) {
                toBeRemoved.prev = last;
            }
            if (toBeRemoved == first) {
                toBeRemoved.next = first;
            }
            toBeRemoved.next = null;
            toBeRemoved.prev = null;
            toBeRemoved.item = null;
            size--;
        }
        return null;
    }

    @Override
    public T remove(T t) {
        if (!isEmpty()) {
            Node<T> node = first;
            for (int i = 0; i < size; i++) {
                if (node.item == t) {
                    return remove(i);
                }
                node = node.next;
            }
        }
        return null;    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
