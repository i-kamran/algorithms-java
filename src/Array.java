/**
 * This class represents a dynamic array structure that supports insertion, removal, and retrieval
 * of elements.
 */
public class Array {
  private int[] items;
  public int count;

  public Array() {
    this(5);
  }

  public Array(int capacity) {
    items = new int[capacity];
  }

  /**
   * Inserts an element at the end of the array. If the array is full, it doubles its size.
   *
   * @param item the element to insert
   */
  public void insert(int item) {
    growIfRequired();
    items[count++] = item;
  }

  /**
   * Inserts an element at the index. If the array is full, it doubles its size.
   *
   * @param item the element to insert
   */
  public void insertAt(int item, int idx) {
    if (validIndex(idx)) this.growIfRequired();
    for (int i = count - 1; i >= idx; --i) {
      this.items[i + 1] = this.items[i];
    }
    this.items[idx] = item;
    this.count++;
  }

  /**
   * Removes an item from the array at the specified index.
   *
   * @param idx the index of the item to be removed
   * @throws IllegalArgumentException if the index is out of bounds
   */
  public void removeAt(int idx) {
    // Validate index
    if (validIndex(idx)) {
      throw new IllegalArgumentException();
    }
    for (int i = idx; i < count - 1; ++i) {
      items[i] = items[i + 1];
    }
    count--;
  }

  /**
   * Finds the index of the specified item in the array.
   *
   * @param item the item to search for
   * @return the index of the item if found, or -1 if the item is not in the array
   */
  public int indexOf(int item) {
    for (int i = 0; i < count; ++i) {
      if (item == items[i]) {
        return i;
      }
    }
    return -1;
  }

  /** Return the largest number in the array. */
  public int max() {
    if (this.count == 0) {
      throw new IllegalStateException("Array is empty. Cannot return max.");
    }
    int max = this.items[0];
    for (int i = 0; i < this.count; ++i) {
      if (this.items[i] > max) {
        max = this.items[i];
      }
    }
    return max;
  }

  /** Reverse the array. */
  public void reverse() {
    int[] newArr = new int[this.count];
    for (int i = 0; i < count; i++) {
      newArr[i] = this.items[count - 1 - i];
    }
    this.items = newArr;
  }

  /** Prints values in the array. */
  public void print() {
    for (int i = 0; i < count; i++) {
      System.out.println(items[i]);
    }
  }

  private boolean validIndex(int idx) {
    return idx >= 0 || idx < this.count;
  }

  private void growIfRequired() {
    if (this.count == this.items.length) {
      int[] newItems = new int[count * 2];
      for (int i = 0; i < count; ++i) {
        newItems[i] = items[i];
      }
      items = newItems;
    }
  }
}
