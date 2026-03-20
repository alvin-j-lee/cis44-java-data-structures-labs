import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            // Average Case
            runAndTimeAllSorts("Average Case", generateRandomArray(n));

            // Best Case
            runAndTimeAllSorts("Best Case (Sorted)", generateSortedArray(n));

            // Worst Case
            runAndTimeAllSorts("Worst Case (Reverse)", generateReverseSortedArray(n));
        }
    }

    /**
     * Runs all sorting algorithms on the same dataset and times them.
     */
    public static void runAndTimeAllSorts(String caseType, int[] originalArray) {

        System.out.println("\n" + caseType + ":");

        // Clone arrays so each algorithm gets identical data
        int[] arr1 = Arrays.copyOf(originalArray, originalArray.length);
        int[] arr2 = Arrays.copyOf(originalArray, originalArray.length);
        int[] arr3 = Arrays.copyOf(originalArray, originalArray.length);

        // Selection Sort
        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(arr1);
        long end = System.nanoTime();
        System.out.println("Selection Sort: " + (end - start) + " ns");

        // Insertion Sort
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(arr2);
        end = System.nanoTime();
        System.out.println("Insertion Sort: " + (end - start) + " ns");

        // Merge Sort
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(arr3);
        end = System.nanoTime();
        System.out.println("Merge Sort: " + (end - start) + " ns");
    }

    /**
     * Generates an array of random integers (Average Case)
     */
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000); // random values
        }

        return arr;
    }

    /**
     * Generates a sorted array (Best Case for Insertion Sort)
     */
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        return arr;
    }

    /**
     * Generates a reverse sorted array (Worst Case)
     */
    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }

        return arr;
    }
}