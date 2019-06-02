package com.autilus.hw3105.task6;

public class App {
    public static void main(String[] args) {
        Person.Builder person = new Person.Builder();
        person.withName("Max")
                .withSurname("Skripai")
                .withAge(19)
                .withGender("man")
                .build();
    }
}
