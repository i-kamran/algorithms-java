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

  private void growArr() {
    capacity *= 2;
    HeapNode[] newItems = new HeapNode[capacity];
    for (int i = 0; i < length; ++i) {
      newItems[i] = items[i];
    }
    items = newItems;
  }

  private void heapifyUp(int idx) {
    int parentIdx = getParentIdx(idx);
    if (items[parentIdx].key > items[idx].key) {
      swap(items, idx, parentIdx);
      heapifyUp(parentIdx);
    }
  }

  private int getParentIdx(int idx) {
    return (idx - 1) / 2;
  }

  private void swap(HeapNode[] arr, int idxA, int idxB) {
    HeapNode temp = items[idxA];
    items[idxA] = items[idxB];
    items[idxB] = temp;
  }
}
