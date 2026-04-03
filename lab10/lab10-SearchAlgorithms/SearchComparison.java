public class SearchComparison {

    /**
     * Lab 1a: Iterative Linear Search
     * Searches for 'key' in the array 'arr' one element at a time.
     * @param arr The array to search (can be unsorted).
     * @param key The value to find.
     * @return The index of the key if found, otherwise -1.
     */
    public static int linearSearch(int[] arr, int key) {
        // Loop through the array from index 0 to the end
        for (int i = 0; i < arr.length; i++) {
            // If current element matches the key, return index
            if (arr[i] == key) {
                return i;
            }
        }
        return -1; // Not found
    }

    /**
     * Lab 1b: Iterative Binary Search
     * Searches for 'key' in a sorted array 'arr' using the divide-and-conquer method.
     * @param arr The array to search (MUST be sorted).
     * @param key The value to find.
     * @return The index of the key if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        // Continue searching while low <= high
        while (low <= high) {
            // Find middle index
            int mid = (low + high) / 2;

            // Check if key is at mid
            if (arr[mid] == key) {
                return mid;
            }
            // If key is smaller, search left half
            else if (key < arr[mid]) {
                high = mid - 1;
            }
            // If key is larger, search right half
            else {
                low = mid + 1;
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] unsortedData = {22, 8, 12, 1, 9, 30, 4, 15};
        int[] sortedData =   {1, 4, 8, 9, 12, 15, 22, 30};

        System.out.println("--- Lab 1: Search Algorithm Implementation ---");

        // Test Linear Search
        System.out.println("Linear Search (Unsorted):");
        System.out.println("Find 9: Index " + linearSearch(unsortedData, 9)); // Expected: 4
        System.out.println("Find 3: Index " + linearSearch(unsortedData, 3)); // Expected: -1

        // Test Binary Search
        System.out.println("\nBinary Search (Sorted):");
        System.out.println("Find 9: Index " + binarySearch(sortedData, 9)); // Expected: 3
        System.out.println("Find 3: Index " + binarySearch(sortedData, 3)); // Expected: -1
        System.out.println("Find 30: Index " + binarySearch(sortedData, 30)); // Expected: 7
    }
}