package com.cozy.collection.stack;

public interface Stack<T> {

    public Stack<T> push(T t);

    public Stack<T> pop() throws Exception;

    public T head() throws Exception;

    public boolean isEmpty();
}
