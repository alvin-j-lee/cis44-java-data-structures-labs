public class MaxSubarraySolver {

    /**
     * Brute Force Approach
     * Checks every possible subarray using nested loops.
     * Time Complexity: O(n^2)
     *
     * Primitive operation analysis:
     * Outer loop runs n times.
     * Inner loop runs up to n times for each i.
     * Total operations ≈ n * n = n^2
     */
    public static int bruteForceMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;

            // Expands subarray starting at i
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j]; // O(1) operation

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * Tracks max subarray ending at each position.
     * Time Complexity: O(n)
     *
     * Analysis:
     * Single loop through array → n iterations
     * Each step does constant work → O(1)
     * Total = O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Either extend subarray or start fresh
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Track global max
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}