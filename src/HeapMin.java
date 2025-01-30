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

  public String remove() {
    if (isEmpty()) {
      throw new IllegalStateException("Heap is empty.");
    }
    String value = items[0].value;
    length--;
    if (length == 0) {
      return value;
    }
    items[0] = items[length];
    heapifyDown();
    return value;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public String peek() {
    if (length == 0) {
      throw new IllegalStateException("Heap is empty");
    }
    return items[0].value;
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
    if (idx == 0) {
      return;
    }

    int parentIdx = getParentIdx(idx);
    if (items[parentIdx].key > items[idx].key) {
      swap(items, idx, parentIdx);
      heapifyUp(parentIdx);
    }
  }

  private void heapifyDown() {
    int idx = 0;
    while (getLeftChildIdx(idx) < length) {
      int smallerChildIdx = getSmallerChildIdx(idx);
      if (items[idx].key <= items[smallerChildIdx].key) {
        break;
      }
      swap(items, idx, smallerChildIdx);
      idx = smallerChildIdx;
    }
  }

  private int getSmallerChildIdx(int idx) {
    int leftIdx = getLeftChildIdx(idx);
    int rightIdx = getRightChildIdx(idx);

    if (leftIdx >= length) {
      return idx;
    }

    if (rightIdx >= length) {
      return leftIdx;
    }

    return items[leftIdx].key < items[rightIdx].key ? leftIdx : rightIdx;
  }

  private int getLeftChildIdx(int idx) {
    return idx * 2 + 1;
  }

  private int getRightChildIdx(int idx) {
    return idx * 2 + 2;
  }

  private int getParentIdx(int idx) {
    return (idx - 1) / 2;
  }

  private void swap(HeapNode[] arr, int idxA, int idxB) {
    HeapNode temp = arr[idxA];
    arr[idxA] = arr[idxB];
    arr[idxB] = temp;
  }
}
