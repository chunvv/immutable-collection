# Java Generic Immutable Collection

### Context
In object-oriented and functional programming, an immutable object is an object whose state cannot be modified after it is created. This is in contrast to a mutable object which can be modified after it is created.

Classes should be immutable unless there's a very good reason to make them mutable. If a class cannot be made immutable, limit its mutability as much as possible. The JDK contains many immutable classes, including String, the boxed primitive classes, and BigInteger and etc. Basically the immutable classes are less prone to error.

### ImmutableStack
- Supports methods:
```java
public interface Stack<T> {

    public Stack<T> push(T t);

    public Stack<T> pop() throws Exception;

    public T top() throws Exception;

    public boolean isEmpty();
}
```
- Test by using ImmutableStack:
```java
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
```

### ImmutableQueue
- Supports methods:
```java
public interface Queue<T> {

    public Queue<T> enQueue(T t);

    public Queue<T> deQueue() throws Exception;

    public T head() throws Exception;

    public boolean isEmpty();
}

```
- Test by using ImmutableQueue:
```java
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
```
