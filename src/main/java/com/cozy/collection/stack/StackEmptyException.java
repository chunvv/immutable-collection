package com.cozy.collection.stack;

public class StackEmptyException extends Exception {

    public StackEmptyException() {
        super("Stack is empty.");
    }
}
