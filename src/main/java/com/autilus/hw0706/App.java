package com.autilus.hw0706;

public class App {
    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        ListImpl list2 = new ListImpl();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list2.add("list2 0");
        list2.add("list2 1");
        list2.add("list2 2");
        list2.add("list2 3");
        list2.add("list2 4");
        list2.add("list2 5");
        list.addAll(list2);
        System.out.println(list.toString());
        System.out.println("remove element");
        list.remove("c");
        System.out.println(list.toString());
        list.remove(3);
        System.out.println(list.toString());
    }
}
