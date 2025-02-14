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
    int leftSize = mid - left + 1;
    int rightSize = right - mid;
    int[] leftArr = new int[leftSize];
    int[] rightArr = new int[rightSize];
    copyArray(arr, leftArr, left);
    copyArray(arr, rightArr, mid + 1);

    int leftPointer = 0;
    int rightPointer = 0;
    int pointer = left;

    while (leftPointer < leftSize && rightPointer < rightSize) {
      if (leftArr[leftPointer] < rightArr[rightPointer]) {
        arr[pointer++] = leftArr[leftPointer++];
      } else {
        arr[pointer++] = rightArr[rightPointer++];
      }
    }

    while (leftPointer < leftSize) {
      arr[pointer++] = leftArr[leftPointer++];
    }
    while (rightPointer < rightSize) {
      arr[pointer++] = rightArr[rightPointer++];
    }
  }

  private void copyArray(int[] arr, int[] newArr, int startIdx) {
    for (int i = 0; i < newArr.length; ++i) {
      newArr[i] = arr[startIdx++];
    }
  }

  public static void main(String args[]) {
    int[] arr = {5, 7, 4, 2, 6, 3, 1, 7, 4};
    System.out.println(Arrays.toString(arr));
    MergeSort sorter = new MergeSort();
    sorter.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
