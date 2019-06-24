package com.autilus.hw1906.task3;

import java.util.stream.IntStream;

public class PseudoRandomStream {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, i -> ((i * i) / 10 % 1000));
    }
}
