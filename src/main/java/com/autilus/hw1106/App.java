package com.autilus.hw1106;

public class App {

    public static void main(String[] args) {
        HashMapImpl hashMap = new HashMapImpl();
        hashMap.put("first", "1");
        hashMap.put("second", "2");
        hashMap.put("third", "3");
        hashMap.put("fourth", "4");
        System.out.println(hashMap.get("1"));
        System.out.println(hashMap.get("2"));
        System.out.println(hashMap.get("3"));
        System.out.println(hashMap.get("4"));
        hashMap.clean();
        System.out.println(hashMap.get("1"));
        System.out.println(hashMap.get("2"));
        System.out.println(hashMap.get("3"));
        System.out.println(hashMap.get("4"));
    }
}
