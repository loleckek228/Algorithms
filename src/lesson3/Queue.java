package lesson3;

import java.util.EmptyStackException;

public class Queue<T> {
    private T[] array;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public Queue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }

        array = (T[]) new Object[capacity];
    }

    public Queue() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return array[begin];
    }

    public void insert(T value) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        array[end] = value;
        end = nextIndex(end);
        size++;
    }

    public T poll() {
        T temp = peek();

        array[begin] = null;
        begin = nextIndex(begin);
        size--;

        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public int size() {
        return size;
    }

    private int nextIndex(int index) {
        return (index + 1) % array.length;
    }
}