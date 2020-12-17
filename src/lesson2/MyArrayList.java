package lesson2;

public class MyArrayList<T extends Comparable<T>> {
    private T[] array;
    private int capacity = 10;
    private int size = 0;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        } else {
            this.capacity = capacity;
            this.array = (T[]) new Comparable[capacity];
        }
    }

    public MyArrayList() {
        array = (T[]) new Comparable[capacity];
    }

    public void add(T value) {
        if (size >= capacity) {
            resize();
        }

        array[size] = value;
        ++size;
    }

    private void resize() {
        int newCapacity = (capacity * 3) / 2 + 1;
        capacity = newCapacity;
        T[] newArray = (T[]) new Comparable[capacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public void add(int index, T item) {
        checkIndex(index);

        for (int i = size; i < index; --i) {
            array[i] = array[i - 1];
        }

        array[index] = item;
        ++size;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index: " + index);
        }
    }

    public void set(int index, T item) {
        checkIndex(index);
        array[index] = item;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    public final int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (item == array[i]) {
                return i;
            }
        }

        return -1;
    }

    public boolean remove(T item) {
        int index = indexOf(item);

        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }

    public void remove(int index) {
        checkIndex(index);

        for (int i = index; i < size - 1; ++i) {
            array[i] = array[i + 1];
        }

        --size;
        array[size] = null;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < size; i++) {
            string.append(array[i]).append(", ");
        }

        if (size > 0) {
            string.setLength(string.length() - 2);
        }

        return string.toString();
    }
}