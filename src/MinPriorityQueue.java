public class MinPriorityQueue {
  HeapMin minHeap = new HeapMin();

  public void add(String value, int priority) {
    minHeap.insert(priority, value);
  }

  public String remove() {
    return minHeap.remove();
  }

  public boolean isEmpty() {
    return minHeap.isEmpty();
  }
}
