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

  private void heapifyUp() {}

  @Override
  public String toString() {
    return Arrays.toString(items);
  }
}
