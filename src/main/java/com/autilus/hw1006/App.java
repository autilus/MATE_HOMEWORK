package com.autilus.hw1006;

import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedListImpl linkedList=new LinkedListImpl();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.remove(2));
        System.out.println(linkedList.get(2));

    }
}
