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
    System.out.println(max);
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
}

