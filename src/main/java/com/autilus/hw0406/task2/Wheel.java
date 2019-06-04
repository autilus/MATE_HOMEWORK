package com.autilus.hw0406.task2;

import java.io.Serializable;

public class Wheel implements Serializable {
    private int radius;
    private String color;

    public Wheel(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
