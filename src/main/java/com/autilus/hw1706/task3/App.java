package com.autilus.hw1706.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] line = bufferedReader.readLine().split(" ");
            int length = line.length;
            LinkedList<String> buffer = new LinkedList<>();
            for (int j = 1; j < length; ++j) {
                if ((j & 1) != 0) {
                    buffer.addFirst(line[j]);
                }
            }
            buffer.forEach(i -> System.out.print(i + " "));
        } catch (Exception e) {
        }
    }
}