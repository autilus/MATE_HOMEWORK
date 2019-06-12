package com.autilus.hw0706;

public class App {
    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.add(1);
        System.out.println( list.size());
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2222,6);
        list.remove(2);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(6));
        System.out.println( list.size());

    }
}
