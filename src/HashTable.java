import java.util.LinkedList;

public class HashTable {
  private class HashEntry {
    private int key;
    private String value;

    private HashEntry(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  private LinkedList<HashEntry>[] table;

  public HashTable() {
    this(100);
  }

  public HashTable(int capacity) {
    table = new LinkedList[capacity];
  }

  public void put(int key, String value) {
    var entry = getEntry(key);
    if (entry != null) {
      entry.value = value;
      return;
    }
    getOrCreateBucket(key).add(new HashEntry(key, value));
  }

  public String get(int key){
    var index = hash(key);
    var bucket = table[index];
    if (bucket != null){
      for (var entry: bucket){
        if (entry.key == key){
          return entry.value;
        }
      }
    }
    return null;
  }
  private LinkedList<HashEntry> getOrCreateBucket(int key) {
    var bucket = getBucket(key);
    if (bucket == null) {
      table[hash(key)] = new LinkedList<>();
    }
    return bucket;
  }

  public HashEntry getEntry(int key) {
    var bucket = getBucket(key);
    if (bucket != null) {
      for (var entry : bucket) {
        if (entry.key == key) {
          return entry;
        }
      }
    }
    return null;
  }

  private LinkedList<HashEntry> getBucket(int key) {
    return table[hash(key)];
  }

  private int hash(int key) {
    return key % table.length;
  }
}
