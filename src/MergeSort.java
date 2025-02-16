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

  private void merge(int[] arr, int left, int mid, int right) {
    int size = right - left + 1;
    int[] newArr = new int[size];
    int leftIdx = left;
    int rightIdx = mid + 1;
    int pointer = 0;

    while (leftIdx <= mid && rightIdx <= right) {
      if (arr[leftIdx] < arr[rightIdx]) {
        newArr[pointer++] = arr[leftIdx++];
      } else {
        newArr[pointer++] = arr[rightIdx++];
      }
    }
    while (leftIdx <= mid) {
      newArr[pointer++] = arr[leftIdx++];
    }
    while (rightIdx <= right) {
      newArr[pointer++] = arr[rightIdx++];
    }

    System.arraycopy(newArr, 0, arr, left, newArr.length);
  }

  public static void main(String args[]) {
    int[] arr = {5, 7, 4, 2, 6, 3, 1, 7, 4};
    System.out.println(Arrays.toString(arr));
    MergeSort sorter = new MergeSort();
    sorter.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
