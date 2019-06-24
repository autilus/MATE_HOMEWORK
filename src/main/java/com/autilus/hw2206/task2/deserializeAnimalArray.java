package com.autilus.hw2206.task2;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class deserializeAnimalArray {
    public static Animal[] DeserializeAnimalArray(byte[] data) {
        int count = 0;
        Animal[] animals = new Animal[0];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            count = objectInputStream.readInt();
            animals = new Animal[count];
            for (int i = 0; i < count; i++) {
                Animal animal = (Animal) objectInputStream.readObject();
                animals[i] = animal;
            }
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException();
        }
        return animals;
    }
}
