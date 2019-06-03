package com.autilus.hw0406.task2;

import java.io.NotSerializableException;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException, NotSerializableException {
        Car bmw = new Car("BMW", "x5", 2018, 280);
        Car bmwClone = (Car) Car.deepClone(bmw);
    }
}
