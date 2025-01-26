import java.util.Arrays;

public class HeapMax {
  private int[] items;
  private int length;
  private int capacity;

  public HeapMax() {
    this(2);
  }

  public HeapMax(int capacity) {
    this.capacity = capacity;
    items = new int[this.capacity];
    length = 0;
  }

  public void insert(int value) {
    if (length == capacity) {
      growArr();
    }
    items[length] = value;
    heapifyUp(length);
    length++;
  }

  public int remove() {
    if (length == 0) {
      throw new IllegalStateException("Cannot remove from an empty heap.");
    }
    int value = items[0];
    items[0] = items[--length];
    heapifyDown(0);
    return value;
  }

  public int peek() {
    if (length == 0) {
      throw new IllegalStateException("Cannot peek an empty heap.");
    }
    return items[0];
  }

  private void growArr() {
    int[] newArr = new int[capacity * 2];
    for (int i = 0; i < capacity; ++i) {
      newArr[i] = items[i];
    }
    capacity *= 2;
    items = newArr;
  }

  private void heapifyUp(int idx) {
    if (idx == 0) {
      return;
    }
    int parentIdx = getParentIdx(idx);
    if (items[idx] < items[parentIdx]) {
      return;
    }
    swap(items, idx, parentIdx);
    heapifyUp(parentIdx);
  }

  private void heapifyDown(int idx) {
    var leftIdx = getLeftChildIdx(idx);
    var rightIdx = getRightChildIdx(idx);
    if (idx >= length || leftIdx >= length) {
      return;
    }

    if (items[idx] < items[leftIdx] && items[leftIdx] > items[rightIdx]) {
      swap(items, idx, leftIdx);
      heapifyDown(leftIdx);
    } else if (items[idx] < items[rightIdx] && items[rightIdx] > items[idx]) {
      swap(items, idx, rightIdx);
      heapifyDown(rightIdx);
    }
  }

  private void swap(int[] arr, int idxA, int idxB) {
    int temp = arr[idxA];
    arr[idxA] = arr[idxB];
    arr[idxB] = temp;
  }

  private int getParentIdx(int idx) {
    return (idx - 1) / 2;
  }

  private int getLeftChildIdx(int idx) {
    return idx * 2 + 1;
  }

  private int getRightChildIdx(int idx) {
    return idx * 2 + 2;
  }

  @Override
  public String toString() {
    return Arrays.toString(items);
  }
}
