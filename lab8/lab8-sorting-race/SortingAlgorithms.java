public class SortingAlgorithms {

    /**
     * Selection Sort
     * Repeatedly finds the minimum element and places it at the beginning.
     * Time Complexity: O(n^2)
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find index of smallest element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Insertion Sort
     * Builds sorted array one element at a time.
     * Best Case: O(n), Worst/Average: O(n^2)
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    /**
     * Merge Sort (public method)
     * Divide-and-conquer sorting algorithm.
     * Time Complexity: O(n log n)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    /**
     * Recursive splitting of array
     */
    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSortRecursive(arr, temp, left, mid);
        mergeSortRecursive(arr, temp, mid + 1, right);

        merge(arr, temp, left, mid, right);
    }

    /**
     * Merges two sorted halves into one sorted section
     */
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {

        int i = left;     // Left subarray pointer
        int j = mid + 1;  // Right subarray pointer
        int k = left;     // Temp array pointer

        // Merge elements in sorted order
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements (if any)
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy back into original array
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }
    }
}