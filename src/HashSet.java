public class HashSet<T> {
  private LinkedListGeneric<T>[] items;

  private int capacity;

  public HashSet() {
    this(5);
  }

  @SuppressWarnings("unchecked")
  public HashSet(int capacity) {
    this.capacity = capacity;
    this.items = new LinkedListGeneric[this.capacity];
  }

  public void put(T value) {
    var entry = getEntry(value);
    if (entry != null) {
      return;
    }
    var bucket = getOrCreateBucket(value);
    bucket.add(value);
  }

  private T getEntry(T value) {
    var bucket = getBucket(value);
    if (bucket == null) {
      return null;
    }
    for (var item : bucket) {
      if (item == value) {
        return value;
      }
    }
    return null;
  }

  private LinkedListGeneric<T> getBucket(T value) {
    return (items[hash(value)]);
  }

  private LinkedListGeneric<T> getOrCreateBucket(T value) {}
}
