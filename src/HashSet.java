public class HashSet<T> {
  private LinkedListGeneric<T>[] items;

  private int capacity;
  private int length;

  public HashSet() {
    this(5);
  }

  @SuppressWarnings("unchecked")
  public HashSet(int capacity) {
    this.capacity = capacity;
    this.items = new LinkedListGeneric[this.capacity];
  }

  public void add(T value) {
    var entry = getEntry(value);
    if (entry != null) {
      return;
    }
    var bucket = getOrCreateBucket(value);
    bucket.add(value);
    length++;
  }

  public boolean remove(T value) {
    var bucket = getBucket(value);

    if (bucket.removeNode(value) == value) {
      this.length--;
      return true;
    }
    return false;
  }

  public int size() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public boolean contains(T value) {
    return getEntry(value) != null;
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

  private LinkedListGeneric<T> getOrCreateBucket(T value) {
    var idx = hash(value);
    var bucket = items[idx];
    if (bucket == null) {
      bucket = new LinkedListGeneric<T>();
      items[idx] = bucket;
    }
    return bucket;
  }

  private int hash(T value) {
    if (value == null) {
      return 0;
    }

    int hashVal;
    if (value instanceof Number) {
      hashVal = ((Number) value).intValue();
    } else {
      hashVal = value.hashCode();
    }

    return Math.abs(hashVal % capacity);
  }
}
