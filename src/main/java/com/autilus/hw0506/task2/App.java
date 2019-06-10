package com.autilus.hw0506.task2;

public class App {
    public static void main(String[] args) throws NullPointerException {
        Storage<Integer, String> storage = new Storage<>();
        storage.put(1, "hey ");
        storage.put(2, "it's ");
        storage.put(3, "me");
        System.out.println("1 -- " + storage.get(1));
        System.out.println("2 -- " + storage.get(2));
        System.out.println("3 -- " + storage.get(3));
    }
}
