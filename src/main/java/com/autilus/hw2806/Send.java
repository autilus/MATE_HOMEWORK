package com.autilus.hw2806;

public static class Send<T> {

    private final String from;
    private final String to;
    private final T content;

    public Send(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContent() {
        return content;
    }
}
