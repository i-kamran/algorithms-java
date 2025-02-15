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
    QuickSort sorter = new QuickSort();

    // Test 1: General case
    int[] arr1 = {5, 7, 4, 2, 6, 3, 1, 7, 4};
    sorter.sort(arr1);
    System.out.println("Test 1 (General case): " + Arrays.toString(arr1));

    // Test 2: Empty array
    int[] arr2 = {};
    sorter.sort(arr2);
    System.out.println("Test 2 (Empty array): " + Arrays.toString(arr2));

    // Test 3: Single-element array
    int[] arr3 = {42};
    sorter.sort(arr3);
    System.out.println("Test 3 (Single element): " + Arrays.toString(arr3));

    // Test 4: Already sorted array
    int[] arr4 = {1, 2, 3, 4, 5, 6};
    sorter.sort(arr4);
    System.out.println("Test 4 (Already sorted): " + Arrays.toString(arr4));

    // Test 5: Reverse sorted array
    int[] arr5 = {6, 5, 4, 3, 2, 1};
    sorter.sort(arr5);
    System.out.println("Test 5 (Reverse sorted): " + Arrays.toString(arr5));

    // Test 6: Array with duplicate values
    int[] arr6 = {4, 2, 4, 1, 2, 3, 4};
    sorter.sort(arr6);
    System.out.println("Test 6 (With duplicates): " + Arrays.toString(arr6));

    // Test 7: Large numbers
    int[] arr7 = {100000, 99999, 55555, 33333, 11111};
    sorter.sort(arr7);
    System.out.println("Test 7 (Large numbers): " + Arrays.toString(arr7));

    // Test 8: Array with negative values
    int[] arr8 = {-5, -1, -3, -2, -4};
    sorter.sort(arr8);
    System.out.println("Test 8 (Negative numbers): " + Arrays.toString(arr8));

    // Test 9: Mixed positive and negative numbers
    int[] arr9 = {3, -1, 2, -5, 0, 4, -2};
    sorter.sort(arr9);
    System.out.println("Test 9 (Mixed numbers): " + Arrays.toString(arr9));

    // Test 10: Large-sized array (Performance test)
    int size = 1000;
    int[] arr10 = new int[size];
    for (int i = 0; i < size; i++) {
      arr10[i] = (int) (Math.random() * 10000);
    }
    sorter.sort(arr10);
    System.out.println("Test 10 (Large array sorted): " + (isSorted(arr10) ? "PASS" : "FAIL"));
  }

  private static boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < arr[i - 1]) return false;
    }
    return true;
  }
}
