package com.autilus.hw0406.task2;

import java.io.NotSerializableException;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException, NotSerializableException {
        Car bmw = new Car("BMW", "x5", 2018, 280, new Wheel(12,"red"));
        Car bmwClone = Car.deepClone(bmw);
    }
}
