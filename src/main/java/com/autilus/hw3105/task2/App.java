package com.autilus.hw3105.task2;

import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.ONE;
        if (value == 1 || value == 0) {
            return result;
        }
        result = BigInteger.valueOf(value).multiply(factorial(value - 1));
        return result;
    }
}
