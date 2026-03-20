import java.util.Random;
import java.util.Arrays;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            int[] arr = generateRandomArrayWithNegatives(n);

            // Clone arrays so both algorithms use same data
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            int[] arr2 = Arrays.copyOf(arr, arr.length);

            // Brute Force Timing
            long start = System.nanoTime();
            int bruteResult = MaxSubarraySolver.bruteForceMaxSum(arr1);
            long end = System.nanoTime();
            System.out.println("Brute Force: " + (end - start) + " ns | Max Sum = " + bruteResult);

            // Kadane Timing
            start = System.nanoTime();
            int kadaneResult = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr2);
            end = System.nanoTime();
            System.out.println("Kadane's Algorithm: " + (end - start) + " ns | Max Sum = " + kadaneResult);
        }
    }

    /**
     * Generates array with both positive and negative values
     */
    public static int[] generateRandomArrayWithNegatives(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            // Range: -100 to 100
            arr[i] = rand.nextInt(201) - 100;
        }

        return arr;
    }
}