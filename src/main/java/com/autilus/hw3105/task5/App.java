package com.autilus.hw3105.task5;

public class App {
    public static void main(String[] args) {
        System.out.println(sqrt(5));
        System.out.println(sqrt(-5));
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);

    }
}
