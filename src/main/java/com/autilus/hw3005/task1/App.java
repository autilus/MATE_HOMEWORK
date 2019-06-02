package com.autilus.hw3005.task1;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] a1 = {0, 7, 14};
        int[] a2 = {1, 3, 7, 11};

        for (int i : app.mergeArrays(a1, a2)) {
            System.out.print(i + " ");
        }
    }

    private static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[(a1.length + a2.length)];
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int index = 0;
        while (firstArrayIndex < a1.length && secondArrayIndex < a2.length) {
            if (a1[firstArrayIndex] < a2[secondArrayIndex]) {
                result[index] = a1[firstArrayIndex];
                firstArrayIndex++;
            } else {
                result[index] = a2[secondArrayIndex];
                secondArrayIndex++;
            }
            index++;
        }
        while (firstArrayIndex < a1.length) {
            result[index] = a1[firstArrayIndex];
            firstArrayIndex++;
            index++;
        }
        while (secondArrayIndex < a2.length) {
            result[index] = a2[secondArrayIndex];
            secondArrayIndex++;
            index++;
        }
        return result;
    }
}
