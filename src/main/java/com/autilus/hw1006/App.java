package com.autilus.hw1006;

public class App {
    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        LinkedListImpl linkedList2 = new LinkedListImpl();
        linkedList.add("first");
        linkedList.add("second");
        linkedList.add("third");
        linkedList.add("fourth");



        linkedList.add("first LL2");
        linkedList.add("second LL2");
        linkedList.add("third LL2");
        linkedList.add("fourth LL2");



        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
        System.out.println("________________________");
linkedList.addAll(linkedList2);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.get(4));
        System.out.println(linkedList.get(5));
        System.out.println(linkedList.get(6));
        System.out.println(linkedList.get(7));
        System.out.println(linkedList.get(8));
    }
}
