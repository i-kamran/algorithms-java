import java.util.HashMap;

public class HashTableExercises {
  public static int mostFrequent(int[] items) {

    if (items.length == 0) {
      throw new IllegalArgumentException("Array is empty.");
    }
    var table = new HashMap<Integer, Integer>();
    for (var item : items) {
      table.put(item, table.get(item) == null ? 1 : table.get(item) + 1);
    }
    int maxFrequency = 0;
    int mostFrequentItem = items[0];

    for (var item : items) {
      int newFrequency = table.get(item);
      if (newFrequency > maxFrequency) {
        maxFrequency = newFrequency;
        mostFrequentItem = item;
      }
    }
    return mostFrequentItem;
  }

  public static void main(String[] args) {
    int[] items = {1, 2, 2, 3, 3, 5, 5, 5};
    int result = mostFrequent(items);
    System.out.println("Most frequent item: " + result); // Output: Most frequent count: 3
  }
}
