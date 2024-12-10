import java.util.Arrays;

public class ArrayQueue {
  private int length;
  private int capacity;
  private int[] items;
  private int head;

  public ArrayQueue() {
    this(5);
  }

  public ArrayQueue(int capacity) {
    this.capacity = capacity;
    this.items = new int[capacity];
    this.length = 0;
    this.head = 0;
  }

  public void enqueue(int item) {
    if (this.length == this.capacity) {
      this.growArray();
    }
    items[this.length++] = item;
  }

  public int dequeue() {
    var item = items[this.head];
    this.items[this.head++] = 0;
    return item;
  }

  @Override
  public String toString() {
    return Arrays.toString(this.items);
  }

  private void growArray() {
    this.capacity = this.capacity * 2;
    int[] newArr = new int[this.capacity];
    for (int i = 0; i < this.length; i++) {
      newArr[i] = this.items[i];
    }
    this.items = newArr;
  }
}
