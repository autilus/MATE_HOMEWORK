package com.autilus.hw3105.task1;

public class App {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }

    public static boolean isPalindrome(String text) {
        String changeText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return changeText.equals(new StringBuffer(changeText).reverse().toString());
    }
}
