package com.autilus.hw1906.task2;

import java.util.function.DoubleUnaryOperator;

public class Integrate {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double x = 0;
        double h = 1.E-6;
        double n = (b - a) / h;
        for (int i = 0; i < n; i++) {
            x += f.applyAsDouble(a + h * i);
        }
        return x * h;
    }
}
