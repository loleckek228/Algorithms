package lesson2;

import java.util.Comparator;

public class SortedFunctions {
    public static MyArrayList<Integer> bubbleSort(MyArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - 1; j++) {
                if (array.get(j).compareTo(array.get(j + 1)) > 0) {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }

        return array;
    }

    public static MyArrayList<Integer> bubbleSort(MyArrayList<Integer> array, Comparator<Integer> comparator) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - 1; j++) {
                if (comparator.compare(array.get(j), array.get(j + 1)) > 0) {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }

        return array;
    }

    public static MyArrayList<Integer> insertionSort(MyArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            int j = i;

            Comparable key;

            for (key = array.get(i); j > 0 && key.compareTo(array.get(j - 1)) < 0; j--) {
                array.set(j, array.get(j - 1));
            }

            array.set(j, (Integer) key);
        }

        return array;
    }

    public static MyArrayList<Integer> insertionSort(MyArrayList<Integer> array, Comparator comparator) {
        for (int i = 0; i < array.size(); i++) {
            int j = i;

            Comparable key;

            for (key = array.get(i); j > 0 && comparator.compare(key, array.get(j - 1)) < 0; j--) {
                array.set(j, array.get(j - 1));
            }

            array.set(j, (Integer) key);
        }

        return array;
    }

    public static MyArrayList<Integer> selectionSort(MyArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {

            Integer min = null;
            for (int j = i + 1; j < array.size(); j++) {
                min = array.get(i);

                if (min.compareTo(array.get(j)) > 0) {
                    min = array.get(j);
                }
            }

            array.set(i, min);
        }

        return array;
    }

    public static MyArrayList<Integer> selectionSort(MyArrayList<Integer> array, Comparator<Integer> comparator) {
        for (int i = 0; i < array.size() - 1; i++) {

            Integer min = null;
            for (int j = i + 1; j < array.size(); j++) {
                min = array.get(i);

                if (comparator.compare(array.get(j), min) < 0) {
                    min = array.get(j);
                }
            }

            array.set(i, min);
        }

        return array;
    }
}