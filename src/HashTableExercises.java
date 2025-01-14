import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  public static int[] twoSum(int[] input, int target) {
    Set<Integer> set = new HashSet<>();
    for (var item : input) {
      if (set.contains(item)) {
        return new int[] {item, target - item};
      }
      set.add(target - item);
    }
    return new int[] {-1};
  }

  public static int countPairsWithDiff(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int counter = 0;

    for (int item : nums) {
      if (map.containsKey(item + k)) {
        counter += map.get(item + k);
      }
      if (map.containsKey(item - k)) {
        counter += map.get(item - k);
      }
      map.put(item, map.getOrDefault(item, 0) + 1);
    }
    return counter;
  }

  public static void main(String[] args) {
    int[] items = {1, 2, 2, 3, 3, 5, 5, 5};
    int result = mostFrequent(items);
    System.out.println("Most frequent item: " + result); // Output: Most frequent count: 3
    int[] twoSumArr = {1, 2, 7, 11, 15};
    int[] twoSumResult = twoSum(twoSumArr, 9);
    System.out.println("Two sum answer:  " + Arrays.toString(twoSumResult));
    int[] pairsArr = {1, 7, 5, 9, 2, 12, 3};
    int pairsDiff = 2;
    int pairsResult = countPairsWithDiff(pairsArr, pairsDiff);
    System.out.println("Pairs with difference " + pairsDiff + ": " + pairsResult);
  }
}
