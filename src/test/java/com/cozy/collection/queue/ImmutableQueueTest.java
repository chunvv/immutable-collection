package com.cozy.collection.queue;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableQueueTest {

    @Test
    public void createNewEmptyQueue() {
        Queue emptyQueue = ImmutableQueue.getEmptyQueue();
        assertTrue(emptyQueue.isEmpty());
    }

    @Test
    public void createNewImmutableQueue() throws Exception {
        Queue emptyQueue = ImmutableQueue.getEmptyQueue();
        Queue immutableQueue = emptyQueue.enQueue(5);
        immutableQueue = immutableQueue.enQueue(2);

        assertThat(immutableQueue.head(), Is.is(5));
        immutableQueue = immutableQueue.deQueue();
        assertThat(immutableQueue.head(), Is.is(2));
        immutableQueue = immutableQueue.deQueue();
        assertTrue(immutableQueue.isEmpty());
    }
}
