import java.util.Random;
import java.util.Arrays;

// --- HeapSort Driver ---
public class HeapSorter {
    public static void heapSort(Integer[] arr) {
        HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<>();

        // Phase 1: Insert all elements into heap
        for (Integer x : arr) {
            pq.insert(x);
        }

        // Phase 2: Remove min elements back into array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.removeMin();
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[10];
        Random rand = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(100);
        }

        System.out.println("Before Sorting: " + Arrays.toString(data));
        heapSort(data);
        System.out.println("After Sorting:  " + Arrays.toString(data));
    }
}