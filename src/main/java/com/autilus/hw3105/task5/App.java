package com.autilus.hw3105.task5;

public class App {
    public static void main(String[] args) {
        System.out.println(sqrt(-5));
    }

    public static double sqrt(double x) {
        if (x >= 0) {
            return Math.sqrt(x);
        } else {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
    }
}
