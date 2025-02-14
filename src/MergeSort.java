import java.util.Arrays;

public class MergeSort {
  public void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private void sort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = ((right - left) / 2 + left);
    sort(arr, left, mid);
    sort(arr, mid + 1, right);
    merge(arr, left, mid, right);
  }
}
