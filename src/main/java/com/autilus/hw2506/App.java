package com.autilus.hw2506;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("[^\\p{L}\\p{Digit}]+");
        Map<String, Integer> map = new HashMap<>();
        scanner.forEachRemaining(i -> map.merge(i.toLowerCase(), 1, Integer::sum));
        map.entrySet().stream()
                .sorted(mapComparator())
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
    private static Comparator<Map.Entry<String, Integer>> mapComparator() {
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }
}
