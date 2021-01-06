package lesson3;

import java.util.EmptyStackException;

public class Stack<T> {
    private T[] array;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }

        array = (T[]) new Object[capacity];
    }

    public Stack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }

        array[size] = item;
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return array[size - 1];
    }

    public T pop() {
        T temp = peek();

        array[size - 1] = null;
        size--;

        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
