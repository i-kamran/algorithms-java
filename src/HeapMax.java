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

  private void growArr() {}

  private void heapifyUp() {}

  @Override
  public String toString() {
    return Arrays.toString(items);
  }
}
