public class HashTableGeneric<K, V> {
  private class HashEntryGeneric<A, B> {
    A key;
    B value;

    private HashEntryGeneric(A key, B value) {
      this.key = key;
      this.value = value;
    }
  }

  LinkedListGeneric<HashEntryGeneric<K, V>>[] table;
  int capacity;

  public HashTableGeneric() {
    this(5);
  }

  @SuppressWarnings("unchecked")
  public HashTableGeneric(int capacity) {
    table = new LinkedListGeneric[capacity];
    this.capacity = capacity;
  }

  public void put(K key, V value) {
    var entry = getEntry(key);
    if (entry == null){
      var bucket = getOrCreateBucket(key);
      bucket.add(new HashEntryGeneric<>(key, value));
      return;
    }
    entry.value = value;

    
  }

  private HashEntryGeneric<K, V> getEntry(K key) {
    int idx = hash(key);
    LinkedListGeneric<HashEntryGeneric<K, V>> bucket = table[idx];
    for (var item : bucket) {
      if (key == item.value) {
        return item;
      }
    }
    return null;
  }

  private LinkedListGeneric<HashEntryGeneric<K, V>> getOrCreateBucket(K key){
    var idx = hash(key);
    var bucket = table[idx];
    if (bucket == null){
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
