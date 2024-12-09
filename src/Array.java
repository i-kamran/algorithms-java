/**
 * This class represents a dynamic array structure that supports insertion, removal, and retrieval
 * of elements.
 */
public class Array {
  private int[] items;
  public int count;

  public Array(int capacity) {
    items = new int[capacity];
  }

  /** Prints values in the array. */
  public void print() {
    for (int i = 0; i < count; i++) {
      System.out.println(items[i]);
    }
  }

  /**
   * Inserts an element at the end of the array. If the array is full, it doubles its size.
   *
   * @param item the element to insert
   */
  public void insert(int item) {
    if (count == items.length) {
      grow();
    }
    items[count++] = item;
  }

  /**
   * Removes an item from the array at the specified index.
   *
   * @param idx the index of the item to be removed
   * @throws IllegalArgumentException if the index is out of bounds
   */
  public void removeAt(int idx) {
    // Validate index
    if (idx < 0 || idx >= count) {
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

  private void grow() {
    int[] newItems = new int[count * 2];
    for (int i = 0; i < count; ++i) {
      newItems[i] = items[i];
    }
    items = newItems;
  }
}
