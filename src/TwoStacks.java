import java.util.Arrays;

public class TwoStacks {
  private int[] arr;
  private int capacity;
  public int leftPointer;
  public int rightPointer;

  public TwoStacks() {
    this(5);
  }

  public TwoStacks(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be positive.");
    }
    this.capacity = capacity;
    this.arr = new int[this.capacity];
    this.leftPointer = -1;
    this.rightPointer = this.capacity;
  }

  public void push1(int item) {
    if (this.isFull()) {
      this.growArr();
    }
    this.arr[++this.leftPointer] = item;
  }

  public int pop1() {
    if (this.isEmpty1()) {
      throw new IllegalStateException("Cannot pop empty stack.");
    }
    return this.arr[this.leftPointer--];
  }

  public void push2(int item) {
    if (this.isFull()) {
      this.growArr();
    }
    this.arr[--this.rightPointer] = item;
  }

  public int pop2() {
    if (this.isEmpty2()) {
      throw new IllegalStateException("Cannot pop an empty stack.");
    }
    return this.arr[this.rightPointer++];
  }

  public boolean isFull() {
    return this.leftPointer + 1 == this.rightPointer;
  }

  public boolean isEmpty1() {
    return this.leftPointer == -1;
  }

  public boolean isEmpty2() {
    return this.rightPointer == this.capacity;
  }

  private void growArr() {
    int newCapacity = this.capacity * 2;
    int[] newArr = new int[newCapacity];
    for (int i = 0; i <= this.leftPointer; ++i) {
      newArr[i] = this.arr[i];
    }
    for (int i = this.capacity - 1; i >= this.rightPointer; --i) {
      newArr[i + this.capacity] = this.arr[i];
    }
    this.rightPointer = this.capacity + this.rightPointer;
    this.capacity = newCapacity;
    this.arr = newArr;
  }

  @Override
  public String toString() {
    return Arrays.toString(this.arr);
  }
}
