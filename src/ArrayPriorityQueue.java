import java.util.Arrays;

public class ArrayPriorityQueue {
  private int[] items;
  private int length;
  private int capacity;

  public ArrayPriorityQueue() {
    this(5);
  }

  public ArrayPriorityQueue(int capacity) {
    this.capacity = capacity;
    this.items = new int[capacity];
    this.length = 0;
  }

  public void add(int item) {
    this.growIfRequired();
    int idx = shiftItemsToInsert(item);
    this.items[idx] = item;
    this.length++;
  }

  public int remove() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot remove from an empty queue.");
    }
    return this.items[this.length--];
  }

  public boolean isEmpty() {
    return this.length == 0;
  }

  @Override
  public String toString() {
    return Arrays.toString(this.items);
  }

  private int shiftItemsToInsert(int item) {
    int idx;
    for (idx = this.length - 1; idx >= 0; --idx) {
      if (item < this.items[idx]) {
        this.items[idx + 1] = this.items[idx];
      } else {
        break;
      }
    }
    return idx + 1;
  }

  private void growIfRequired() {
    if (this.length == this.capacity) {
      this.capacity *= 2;
      int[] newItems = new int[this.capacity];
      for (int i = 0; i < this.length; ++i) {
        newItems[i] = this.items[i];
      }
      this.items = newItems;
    }
  }
}
