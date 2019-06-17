package com.autilus.hw1706.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList list = new ArrayList();
            list.addAll(Arrays.asList(scanner.nextLine().split(" ")));
            list.removeIf(n -> (list.indexOf(n) % 2 == 0));
            Collections.reverse(list);
            for (Object o : list) {
                System.out.print(o + " ");
            }
        } catch (RuntimeException E){}
    }
}
