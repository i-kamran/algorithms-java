import java.util.Arrays;

public class QuickSort {
  public void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private void quickSort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivotIdx = partition(arr, left, right);
    quickSort(arr, left, pivotIdx - 1);
    quickSort(arr, pivotIdx + 1, right);
  }

  public int partition(int[] arr, int left, int right) {
    int pivotIdx = (right - left) / 2 + left;
    swap(arr, pivotIdx, right);
    int pointer = left;
    for (int i = left; i < right; ++i) {
      if (arr[i] < arr[right]) {
        swap(arr, i, pointer++);
      }
    }
    swap(arr, pointer, right);
    return pointer;
  }

  public void swap(int[] arr, int idxA, int idxB) {
    int temp = arr[idxA];
    arr[idxA] = arr[idxB];
    arr[idxB] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {5, 1, 1, 2, 0, 0};
    System.out.println(Arrays.toString(arr));
    MergeSort sorter = new MergeSort();
    sorter.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
