/**
 * SimpleSorters.java
 *
 * This class implements two O(n^2) sorting algorithms:
 * 1. bubbleSort: Optimized bubble sort with early termination using a swapped flag.
 * 2. insertionSort: Standard insertion sort that shifts elements to insert correctly.
 *
 * Both methods are generic and use a Comparator for flexibility.
 */

import java.util.Comparator;

public class SimpleSorters {

    /**
     * Sorts an array using optimized Bubble Sort.
     * @param S The array to sort
     * @param comp Comparator used for ordering
     */
    public static <K> void bubbleSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (comp.compare(S[j], S[j + 1]) > 0) {
                    // swap
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;
                    swapped = true;
                }
            }

            // early stop if already sorted
            if (!swapped) break;
        }
    }

    /**
     * Sorts an array using Insertion Sort.
     * @param S The array to sort
     * @param comp Comparator used for ordering
     */
    public static <K> void insertionSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 1; i < n; i++) {
            K cur = S[i];
            int j = i - 1;

            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            S[j + 1] = cur;
        }
    }
}