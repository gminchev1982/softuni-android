package com.example.gminchev.notification.Model;

public class Message {
    private String text;
    private String keyChild;

    public Message() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKeyChild() {
        return keyChild;
    }

    public void setKeyChild(String keyChild) {
        this.keyChild = keyChild;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", keyChild='" + keyChild + '\'' +
                '}';
    }
}
