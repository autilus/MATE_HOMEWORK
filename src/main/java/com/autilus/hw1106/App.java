package com.autilus.hw1106;

public class App {

    public static void main(String[] args) {
        HashMapImpl hashMap = new HashMapImpl();
        hashMap.put("first", null);
        hashMap.put("second", "1");
        hashMap.put("third", "2");
        hashMap.put("four", "3");
        hashMap.put("fifth", "4");
        System.out.println(hashMap.get("0"));
        System.out.println(hashMap.get("1"));
        System.out.println(hashMap.get("2"));
        System.out.println(hashMap.get("3"));
        System.out.println(hashMap.get("4"));

    }
}
