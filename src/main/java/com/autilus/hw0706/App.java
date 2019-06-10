package com.autilus.hw0706;

public class App {
    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(18, 1);
        list.remove(2);
    }
}
