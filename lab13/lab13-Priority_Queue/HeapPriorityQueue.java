import java.util.ArrayList;

class HeapPriorityQueue<K extends Comparable<K>> {
    private ArrayList<K> heap = new ArrayList<>();

    // Helper methods
    protected int parent(int j) { return (j - 1) / 2; }
    protected int left(int j) { return 2 * j + 1; }
    protected int right(int j) { return 2 * j + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }

    private void swap(int i, int j) {
        K temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(K key) {
        heap.add(key);
        upheap(heap.size() - 1);
    }

    public K removeMin() {
        if (isEmpty()) return null;

        K answer = heap.get(0);

        // Move last element to root
        K last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);
        }

        return answer;
    }

    public K min() {
        return isEmpty() ? null : heap.get(0);
    }

    private void upheap(int j) {
        while (j > 0) {
            int p = parent(j);

            // If parent <= current, heap is valid
            if (heap.get(j).compareTo(heap.get(p)) >= 0) {
                break;
            }

            // Otherwise swap and continue
            swap(j, p);
            j = p;
        }
    }

    private void downheap(int j) {
        while (left(j) < heap.size()) { // has left child
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;

            int rightIndex = right(j);

            // Check if right child exists and is smaller
            if (rightIndex < heap.size() &&
                    heap.get(rightIndex).compareTo(heap.get(leftIndex)) < 0) {
                smallChildIndex = rightIndex;
            }

            // If parent <= smallest child, heap is valid
            if (heap.get(j).compareTo(heap.get(smallChildIndex)) <= 0) {
                break;
            }

            // Otherwise swap and continue
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }
}