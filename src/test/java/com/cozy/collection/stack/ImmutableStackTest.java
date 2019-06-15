package com.cozy.collection.stack;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableStackTest {

    @Test
    public void createNewEmptyStack() {
        Stack emptyStack = ImmutableStack.getEmptyStack();
        assertTrue(emptyStack.isEmpty());
    }

    @Test
    public void createNewImmutableStack() throws Exception {
        Stack emptyStack = ImmutableStack.getEmptyStack();
        Stack immutableStack = emptyStack.push(5);
        immutableStack = immutableStack.push(2);

        assertThat(immutableStack.top(), Is.is(2));
        immutableStack = immutableStack.pop();
        assertThat(immutableStack.top(), Is.is(5));
        immutableStack = immutableStack.pop();
        assertTrue(immutableStack.isEmpty());
    }
}
