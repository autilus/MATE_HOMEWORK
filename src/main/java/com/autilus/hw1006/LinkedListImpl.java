package com.autilus.hw1006;

import java.util.NoSuchElementException;

public class LinkedListImpl<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    private void checkIndex(int index) {
        if (index < 0 || index > size) throw new NoSuchElementException();
    }

    private Node<T> getNodeByIndex(int index) {
        checkIndex(index + 1);
        Node<T> node;
        if (index < size << 1) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = last;
            for (int i = size; i > index; i--) {
                node = node.getPrev();
            }
        }
        return node;
    }

    private Node<T> getNodeByValue(T value) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (node.getValue().equals(value)) {
                break;
            } else {
                node = node.getNext();
            }
        }
        return node;
    }

    @Override
    public void add(T value) {
        Node<T> node = new Node<>(last, value, null);
        if (isEmpty()) {
            first = node;
        } else {
            last.setNext(node);
        }
        last = node;
        size++;
    }

    @Override
    public void add(T value, int index) {
        checkIndex(index);
        if (isEmpty() || index == size) {
            add(value);
        } else {
            Node<T> nextNode = getNodeByIndex(index);
            Node<T> prevNode = nextNode.getPrev();
            Node<T> node = new Node<>(prevNode, value, nextNode);
            if (index == 0) {
                first = node;
            } else {
                prevNode.setNext(node);
            }
            nextNode.setPrev(node);
            size++;
        }
    }

    @Override
    public void addAll(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        return getNodeByIndex(index).getValue();
    }

    @Override
    public void set(T value, int index) {
        getNodeByIndex(index).setValue(value);
    }

    @Override
    public T remove(int index) {
        Node<T> node = getNodeByIndex(index);
        Node<T> prevNode = node.getPrev();
        Node<T> nextNode = node.getNext();
        T result = node.getValue();
        if (index == 0) {
            first = nextNode;
            first.setPrev(null);
        } else if (index + 1 == size) {
            last = prevNode;
            last.setNext(null);
        } else {
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
        }
        size--;
        node = null;
        return result;
    }

    @Override
    public T remove(T value) {
        Node<T> node = getNodeByValue(value);
        if (node == null) {
            throw new NoSuchElementException();
        }
        Node<T> prevNode = node.getPrev();
        Node<T> nextNode = node.getNext();
        if (prevNode == null) {
            first = nextNode;
            first.setPrev(null);
        } else if (nextNode == null) {
            last = prevNode;
            last.setNext(null);
        } else {
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
        }
        size--;
        node = null;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        private Node<T> prev;
        private T value;
        private Node<T> next;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
