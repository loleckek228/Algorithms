package lesson2;

import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> array = getArrayWithRandomValues();
        System.out.println(array);

        MyArrayList<Integer> sortedArrayByBubble = SortedFunctions.bubbleSort(array);
        System.out.println("SortedArrayByBubble: " + sortedArrayByBubble);

        MyArrayList<Integer> sortedArrayByBubbleWithComparator = SortedFunctions.bubbleSort(array, Comparator.naturalOrder());
        System.out.println("SortedArrayByBubbleWithComparator: " + sortedArrayByBubbleWithComparator);

        MyArrayList<Integer> sortedArrayByInsertion = SortedFunctions.insertionSort(array);
        System.out.println("SortedArrayByInsertion: " + sortedArrayByInsertion);

        MyArrayList<Integer> sortedArrayByInsertionWithComparator = SortedFunctions.insertionSort(array, Comparator.naturalOrder());
        System.out.println("SortedArrayByInsertionWithComparator: " + sortedArrayByInsertionWithComparator);

        MyArrayList<Integer> sortedArrayBySelection = SortedFunctions.selectionSort(array);
        System.out.println("SortedArrayBySelection: " + sortedArrayBySelection);

        MyArrayList<Integer> sortedArrayBySelectionWithComparator = SortedFunctions.selectionSort(array, Comparator.naturalOrder());
        System.out.println("SortedArrayBySelectionWithComparator: " + sortedArrayBySelectionWithComparator);
    }

    private static MyArrayList<Integer> getArrayWithRandomValues() {
        int size = 1_0;
        MyArrayList<Integer> array = new MyArrayList<>(size);

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomValue = random.nextInt(10);
            array.add(randomValue);
        }

        return array;
    }
}