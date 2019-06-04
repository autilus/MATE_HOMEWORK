package com.autilus.hw3105.task3;

public class AsciiCharSequence implements CharSequence {
    byte[] input;

    public AsciiCharSequence(byte[] input) {
        this.input = input;
    }

    public int length() {
        return input.length;
    }

    public char charAt(int position) {
        return (char) input[position];
    }

    @Override
    public CharSequence subSequence(int startPosition, int endPosition) {
        if (startPosition < endPosition) {
            throw new RuntimeException("start posotion < then end position");
        }
        byte[] subSequence = new byte[endPosition - startPosition];
        for (int i = startPosition; i < endPosition; i++) {
            subSequence[i - startPosition] = input[i];
        }
        return new AsciiCharSequence(subSequence);
    }

    @Override
    public String toString() {
        return new String(this.input);
    }
}

