import java.util.Arrays;

/** 
 * Stack class implemented using and array.
 * */
public class StackArray {
  private int[] items;
  private int capacity;
  private int length;

  public StackArray() {
    this(5);
  }

  public StackArray(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be greater than 0");
    }
    this.items = new int[capacity];
    this.capacity = capacity;
    this.length = 0;
  }

  public void push(int item) {
    if (this.capacity == this.length) {
      this.growArray();
    }
    items[this.length++] = item;
  }

  public int pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty.");
    }
    return this.items[--this.length];
  }

  public boolean isEmpty() {
    return this.length == 0;
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty.");
    }
    return this.items[this.length - 1];
  }

  @Override
  public String toString() {
    var content = Arrays.copyOfRange(this.items, 0, this.length);
    return Arrays.toString(content);
  }

  private void growArray() {
    int[] newArr = new int[this.capacity * 2];
    for (var i = 0; i < this.capacity; ++i) {
      newArr[i] = this.items[i];
    }
    this.capacity = this.capacity * 2;
    this.items = newArr;
  }
}
