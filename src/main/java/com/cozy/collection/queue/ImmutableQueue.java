package com.cozy.collection.queue;

import com.cozy.collection.Reversible;
import com.cozy.collection.stack.ImmutableStack;
import com.cozy.collection.stack.Stack;

public class ImmutableQueue<T> implements Queue<T>, Reversible<Stack> {

    private final Stack<T> inGoing;
    private final Stack<T> outGoing;

    private ImmutableQueue(Stack<T> inGoing, Stack<T> outGoing) {
        this.inGoing = inGoing;
        this.outGoing = outGoing;
    }

    @Override
    public Queue<T> enQueue(T t) {
        return new ImmutableQueue<>(inGoing, outGoing.push(t));
    }

    @Override
    public Queue<T> deQueue() throws Exception {
        Stack<T> f = inGoing.pop();

        if (!f.isEmpty()) {
            return new ImmutableQueue<T>(f, outGoing);
        } else if (outGoing.isEmpty()) {
            return ImmutableQueue.getEmptyQueue();
        } else {
            return new ImmutableQueue<T>(reverse(outGoing), ImmutableStack.initEmptyStack());
        }
    }

    @Override
    public T head() throws Exception {
        return inGoing.head();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public final static Queue getEmptyQueue() {
        return EmptyQueue.getInstance();
    }

    @Override
    public Stack reverse(Stack stack) throws Exception {
        Stack r = ImmutableStack.initEmptyStack();
        while (!stack.isEmpty()) {
            r = r.push(stack.head());
            stack = stack.pop();
        }

        return r;
    }


    private static final class EmptyQueue<T> implements Queue<T> {

        private final static EmptyQueue emptyQueue = new EmptyQueue();

        public final static EmptyQueue getInstance() {
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
}
