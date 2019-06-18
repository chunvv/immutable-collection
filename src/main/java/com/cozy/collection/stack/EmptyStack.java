package com.cozy.collection.stack;

/**
 * Singleton pattern
 */
final class EmptyStack<T> implements Stack<T> {

    private final static EmptyStack emptyStack = new EmptyStack();

    static EmptyStack getInstance() {
        return emptyStack;
    }

    @Override
    public Stack<T> push(T t) {
        return new ImmutableStack<>(t, this);
    }

    @Override
    public Stack<T> pop() throws Exception {
        throw new StackEmptyException();
    }

    @Override
    public T head() throws Exception {
        throw new StackEmptyException();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}
