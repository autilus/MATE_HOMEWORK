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
        for (int i = 0; i < result.length; i++) {
            int leftNumber;
            int rightNumber;
            if (firstArrayIndex < a1.length) {
                leftNumber = a1[firstArrayIndex];
            } else {
                leftNumber = Integer.MAX_VALUE;
            }

            if (secondArrayIndex < a2.length) {
                rightNumber = a2[secondArrayIndex];
            } else {
                rightNumber = Integer.MAX_VALUE;
            }
            if (leftNumber < rightNumber) {
                result[i] = leftNumber;
                firstArrayIndex++;
            } else {
                result[i] = rightNumber;
                secondArrayIndex++;
            }
        }
        return result;
    }
}
