package com.autilus.hw3105.task1;

public class App {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder revercedText = new StringBuilder();
        revercedText.append(text);
        revercedText.reverse();
        if (text.compareTo(String.valueOf(revercedText)) != 0) {
            return false;
        }
        return true;
    }
}
