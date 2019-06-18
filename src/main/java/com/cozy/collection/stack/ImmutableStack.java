package com.cozy.collection.stack;

public class ImmutableStack<T> implements Stack<T> {

    private final T head;
    private final Stack<T> next;

    public ImmutableStack(T data, Stack<T> next) {
        this.head = data;
        this.next = next;
    }

    @Override
    public Stack<T> push(T t) {
        return new ImmutableStack<>(t, this);
    }

    @Override
    public Stack<T> pop() {
        return next;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public T head() {
        return head;
    }

    public static Stack initEmptyStack() {
        return EmptyStack.getInstance();
    }
}
