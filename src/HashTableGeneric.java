public class HashTableGeneric<K, V> {
  private class HashEntryGeneric<A, B> {
    A key;
    B value;

    private HashEntryGeneric(A key, B value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      return "key: " + key + ", value: " + value;
    }
  }

  LinkedListGeneric<HashEntryGeneric<K, V>>[] table;
  int capacity;

  public HashTableGeneric() {
    this(5);
  }

  @SuppressWarnings("unchecked")
  public HashTableGeneric(int capacity) {
    this.capacity = capacity;
    this.table = new LinkedListGeneric[this.capacity];
  }

  public void put(K key, V value) {
    var entry = getEntry(key);
    if (entry == null) {
      var bucket = getOrCreateBucket(key);
      bucket.add(new HashEntryGeneric<>(key, value));
      return;
    }
    entry.value = value;
  }

  public V get(K key) {
    var entry = getEntry(key);
    return (entry == null) ? null : entry.value;
  }

  public V remove(K key) {
    var entry = getEntry(key);
    if (entry == null) {
      return null;
    }
    getBucket(key).removeNode(entry);
    return entry.value;
  }

  public boolean containsKey(K key) {
    return getEntry(key) != null;
  }

  public V getOrDefault(K key, V defValue) {
    var entry = getEntry(key);
    if (entry == null) {
      return defValue;
    }
    return entry.value;
  }

  public int getHash(K key) {
    return hash(key);
  }

  private HashEntryGeneric<K, V> getEntry(K key) {
    int idx = hash(key);
    LinkedListGeneric<HashEntryGeneric<K, V>> bucket = table[idx];
    if (bucket != null) {
      for (var item : bucket) {
        if (key == item.key) {
          return item;
        }
      }
    }
    return null;
  }

  private LinkedListGeneric<HashEntryGeneric<K, V>> getOrCreateBucket(K key) {
    var idx = hash(key);
    var bucket = table[idx];
    if (bucket == null) {
      bucket = new LinkedListGeneric<HashEntryGeneric<K, V>>();
      table[idx] = bucket;
    }
    return bucket;
  }

  private LinkedListGeneric<HashEntryGeneric<K, V>> getBucket(K key) {
    return table[hash(key)];
  }

  private int hash(K key) {
    // Handle null keys
    if (key == null) {
      return 0;
    }

    // Convert key to number based on its type
    int hashVal;
    if (key instanceof Number) {
      hashVal = ((Number) key).intValue();
    } else {
      // For non-numeric types, use Java's hashCode()
      hashVal = key.hashCode();
    }

    // Ensure positive value and fit within capacity
    return Math.abs(hashVal % capacity);
  }
}
