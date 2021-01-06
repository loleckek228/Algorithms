package lesson3;

import java.util.EmptyStackException;

class Deque<T> {
    private T[] array;
    private int tail = 0;
    private int head = 0;
    private int size;
    private double loadFactor = 0.75;

    public Deque() {
        this(10);
    }

    public Deque(int capacity) {
        this(capacity, 0.75);
    }

    public Deque(int capacity, double loadFactor) {
        setLoadFactor(loadFactor);

        if (capacity > 0) {
            array = (T[]) new Object[capacity];
        } else {
            throw new IllegalArgumentException();
        }
    }


    public boolean pushBackValue(T value) {
        size++;

        expand();

        array[tail] = value;
        tail = nextIndex(tail);

        return true;
    }

    public boolean pushFrontValue(T value) {
        size++;

        expand();

        head = lastIndex(head);
        array[head] = value;

        return true;
    }

    public T popBack() {
        T value = array[lastIndex(tail)];

        size--;
        tail = lastIndex(tail);
        array[tail] = null;

        return value;
    }

    public T popFront() {
        T value = array[head];

        size--;
        array[head] = null;
        head = nextIndex(head);

        return value;
    }

    public T peekBack() {
        if (size <= 0) {
            throw new EmptyStackException();
        }

        return array[head];
    }

    public T peekFront() {
        if (size <= 0) {
            throw new EmptyStackException();
        }

        return array[lastIndex(tail)];
    }

    private int nextIndex(int index) {
        return (index + 1) % array.length;
    }

    private int lastIndex(int index) {
        return (array.length + index - 1) % array.length;
    }

    private final void setLoadFactor(double loadFactor) {
        if (loadFactor > 0 && loadFactor < 1) {
            this.loadFactor = loadFactor;
        }
    }

    private void expand() {
        if ((double) size / array.length > loadFactor) {
            T[] tempArr = (T[]) new Object[array.length * 2];
            if (head <= tail) {
                System.arraycopy(array, 0, tempArr, 0, array.length);
            } else {
                System.arraycopy(array, 0, tempArr, 0, tail);

                int newHead = tempArr.length - array.length + head;

                System.arraycopy(array, head, tempArr, newHead, array.length - head);
                head = newHead;
            }

            array = tempArr;
        }
    }
}