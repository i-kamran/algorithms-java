public class HashTable {

  private class HashEntry {
    private int key;
    private String value;

    private HashEntry(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  private LinkedListGeneric<HashEntry>[] table;
  int capacity;

  public HashTable() {
    this(5);
  }

  public HashTable(int capacity) {
    this.capacity = capacity;
    table = new LinkedListGeneric[capacity];
  }

  public void put(int key, String value) {
    var entry = getEntry(key);
    if (entry == null) {
      getOrCreateBucket(key).add(new HashEntry(key, value));
      return;
    }
    entry.value = value;
  }

  public void remove(int key) {
    var entry = getEntry(key);
    if (entry == null) {
      return;
    }
    getBucket(key).removeNode(entry);
  }

  public String get(int key) {
    var entry = getEntry(key);
    return (entry == null) ? null : entry.value;
  }

   public int getHash(int key){
    return hash(key);
  }

  private LinkedListGeneric<HashEntry> getOrCreateBucket(int key) {
    var idx = hash(key);
    var bucket = table[idx];
    if (bucket == null) {
      bucket = new LinkedListGeneric<HashEntry>();
      table[idx] = bucket;
    }
    return bucket;
  }

  private HashEntry getEntry(int key) {
    var bucket = getBucket(key);
    if (bucket != null) {
      for (var item : bucket) {
        if (item.key == key) {
          return item;
        }
      }
    }
    return null;
  }


  private LinkedListGeneric<HashEntry> getBucket(int key) {
    return table[hash(key)];
  }

  private int hash(int key) {
    return (key * 31 % capacity + capacity) % capacity;
  }
}
