import java.util.Arrays;

public class HeapMax {
  private int[] items;
  private int length;
  private int capacity;

  public HeapMax(int capacity) {
    this.capacity = capacity;
    items = new int[this.capacity];
    length = 0;
  }

  public void insert(int value) {
    if (length == capacity) {
      growArr();
    }
    items[length++] = value;
    heapifyUp();
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

  private void heapifyDown(int idx){
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
