import java.util.Arrays;

public class QueueCircularArray {
  private int[] arr;
  private int capacity;
  private int length;
  private int tail;
  private int head;

  public QueueCircularArray() {
    this(5);
  }

  public QueueCircularArray(int capacity) {
    this.capacity = capacity;
    this.arr = new int[capacity];
    this.head = this.tail = this.length = 0;
  }

  public void enqueue(int item) {
    growIfRequired();

    this.arr[this.tail] = item;
    this.tail = (this.tail + 1) % this.capacity;
    this.length++;
  }

  public int dequeue() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot dequeue an empty queue.");
    }
    int value = this.arr[this.head];
    this.head = (this.head + 1) % this.capacity;
    this.length--;
    return value;
  }

  public int peek() {

    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot dequeue an empty queue.");
    }
    return this.arr[this.head];
  }

  public boolean isEmpty() {
    return this.length == 0;
  }

  public boolean isFull() {
    return this.length == this.capacity;
  }

  @Override
  public String toString() {
    return Arrays.toString(this.arr);
  }

  private void growIfRequired() {
    if (this.isFull()) {
      int newCapacity = capacity * 2;
      int[] newArr = new int[newCapacity];

      int count = this.head;
      for (int i = 0; i < this.capacity; ++i) {
        newArr[i] = this.arr[count];
        count = (count + 1) % this.capacity;
      }
      this.head = 0;
      this.tail = this.length;
      this.capacity = newCapacity;
      this.arr = newArr;
    }
  }
}
