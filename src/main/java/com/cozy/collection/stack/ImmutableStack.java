package com.cozy.collection.stack;

public class ImmutableStack<T> implements Stack<T> {

    private final T top;
    private final Stack<T> next;

    private ImmutableStack(T data, Stack<T> next) {
        this.top = data;
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

    public T top() {
        return top;
    }

    public final static Stack getEmptyStack() {
        return EmptyStack.getInstance();
    }

    private static final class EmptyStack<T> implements Stack<T> {

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
        public T top() throws Exception {
            throw new StackEmptyException();
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }
}
