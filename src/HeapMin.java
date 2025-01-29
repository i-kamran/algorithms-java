public class HeapMin {
  private class HeapNode {
    int key;
    String value;

    private HeapNode(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  private HeapNode[] items;
  private int length;
  private int capacity;

  public HeapMin() {
    this(5);
  }

  public HeapMin(int capacity) {
    this.capacity = capacity;
    items = new HeapNode[capacity];
    this.length = 0;
  }

  public void insert(int key, String value) {
    if (length == this.capacity) {
      growArr();
    }
    items[length] = new HeapNode(key, value);
    heapifyUp(length);
    length++;
  }

  private void growArr() {}

  private void heapifyUp(int idx) {}
}
