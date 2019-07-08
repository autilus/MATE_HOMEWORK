package com.autilus.hw2806;

public class MailMessage extends Send<String> {
    public MailMessage(String from, String to, String message) {
        super(from, to, message);
    }
}
