import java.util.*;

public class DataStructures {
    // ==========================================
    // 1. RECURSION
    // ==========================================
    /**
    * Calculate the nth Fibonacci number recursively.
    */
    public static int recursiveFibonacci(int n) {
          // Base cases
          if (n == 0) return 0;
          if (n == 1) return 1;

          // Recursive step
          return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

      // ==========================================
      // 2. ANALYSIS OF ALGORITHMS
      // ==========================================
      /**
      * Find and return the SECOND LARGEST value in an array.
      */
    public static int findSecondMax(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements"); 
        }

         // 'max' to store the largest value found so far
        int max = Integer.MIN_VALUE;

        // 'secondMax' to store the second largest value
         int secondMax = Integer.MIN_VALUE;

         // Loop through the array ONCE (O(n))
         for (int num : arr) {

            // Case 1: Found a new maximum
           if (num > max) {
                 // The old max becomes the second max
                secondMax = max;

                 // Update max to the new highest value
                 max = num;
            }

             // Case 2: num is NOT the max, but could be second max
            else if (num > secondMax && num != max) {
               // Update second max only if:
                 // - it's bigger than current secondMax
                // - it's NOT equal to max (avoid duplicates like [5,5])
                secondMax = num;
            }
        }
        return secondMax;
    }

       // ==========================================
       // 3. TREES
       // ==========================================
    static class Node {
        int value;
        Node left, right;
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

     /**
     * Return the sum of values of ONLY the leaf nodes.
     */
    public static int sumLeafNodes(Node root) {
        if (root == null) return 0;

        // If leaf node
        if (root.left == null && root.right == null) {
            return root.value;
        }

        // Recurse on children
        return sumLeafNodes(root.left) + sumLeafNodes(root.right);
    }

      // ==========================================
      // 4. SEARCH ALGORITHMS
      // ==========================================
      /**
      * Implement Binary Search on a SORTED array.
      */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

      // ==========================================
      // 5. SORTING ALGORITHMS
      // ==========================================
      /**
      * Implement Selection Sort to sort the array in ascending order.
      */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find minimum in unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap once per outer loop
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

      // ==========================================
      // TEST DRIVER (Do not modify this part)
      // ==========================================
    public static void main(String[] args) {
        System.out.println("=== Coding Advanced Data Structures ===\n");

        int fibN = 6;
        int expectedFib = 8;
        int actualFib = recursiveFibonacci(fibN);
        printTestResult("1. Recursion (Fibonacci)", expectedFib, actualFib);

        int[] numbers = {10, 5, 20, 8, 15};
        int expectedSecondMax = 15;
        int actualSecondMax = findSecondMax(numbers);
        printTestResult("2. Analysis (Second Max)", expectedSecondMax, actualSecondMax);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        int expectedLeafSum = 7;
        int actualLeafSum = sumLeafNodes(root);
        printTestResult("3. Trees (Leaf Sum)", expectedLeafSum, actualLeafSum);

        int[] sortedData = {1, 2, 4, 7, 9};
        int target = 7;
        int expectedIndex = 3;
        int actualIndex = binarySearch(sortedData, target);
        printTestResult("4. Search (Binary)", expectedIndex, actualIndex);

        int[] sortData = {64, 25, 12, 22, 11};
        String expectedSort = "[11, 12, 22, 25, 64]";
        selectionSort(sortData);
        String actualSort = Arrays.toString(sortData);
        System.out.println("[Test 5] Sorting (Selection Sort)");
        System.out.println(" Expected: " + expectedSort);
        System.out.println(" Actual: " + actualSort);
        if (expectedSort.equals(actualSort)) {
            System.out.println(" Result: [PASS]");          
        } else {
            System.out.println(" Result: [FAIL]");
        }
        System.out.println();
    }

    private static void printTestResult(String testName, int expected, int actual) {
        System.out.println("[Test] " + testName);
        System.out.println(" Expected: " + expected);
        System.out.println(" Actual: " + actual);
        if (expected == actual) {
            System.out.println(" Result: [PASS]");
        } else {
            System.out.println(" Result: [FAIL]");
        }
        System.out.println();
    }
}