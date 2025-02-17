import java.util.Arrays;

public class CountSort {
  public void sort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    int max = arr[0];
    for (int item : arr) {
      if (max < item) {
        max = item;
      }
      if (item < 0) {
        return;
      }
    }
    max++;
    int[] counts = new int[max];
    for (int item : arr) {
      counts[item] += 1;
    }

    int pointer = 0;
    for (int i = 0; i < counts.length; ++i) {
      int count = counts[i];
      if (count == 0) {
        continue;
      }
      while (count > 0) {
        arr[pointer++] = i;
        count--;
      }
    }
  }

  public static void main(String[] args) {
    CountSort sorter = new CountSort();

    int[] arr1 = {5, 2, 3, 1};
    sorter.sort(arr1);
    System.out.println("Sorted: " + Arrays.toString(arr1)); // [1, 2, 3, 5]

    int[] arr2 = {10, -2, 0, 5, 3, 8, 1};
    sorter.sort(arr2);
    System.out.println("Sorted: " + Arrays.toString(arr2)); // [-2, 0, 1, 3, 5, 8, 10]

    int[] arr3 = {};
    sorter.sort(arr3);
    System.out.println("Sorted: " + Arrays.toString(arr3)); // []

    int[] arr4 = {1, 2, 3, 4, 5};
    sorter.sort(arr4);
    System.out.println("Sorted: " + Arrays.toString(arr4)); // [1, 2, 3, 4, 5]
  }
}

