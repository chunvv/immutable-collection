package com.cozy.collection.queue;

import com.cozy.collection.stack.ImmutableStack;

final class EmptyQueue<T> implements Queue<T> {

    private final static EmptyQueue emptyQueue = new EmptyQueue();

    static EmptyQueue getInstance() {
        return emptyQueue;
    }

    public final Queue<T> enQueue(T t) {
        return new ImmutableQueue<T>(ImmutableStack.initEmptyStack().push(t), ImmutableStack.initEmptyStack());
    }

    public final Queue<T> deQueue() throws Exception {
        throw new EmptyQueueException();
    }

    public final T head() throws Exception {
        throw new EmptyQueueException();
    }

    public final boolean isEmpty() {
        return true;
    }
}
