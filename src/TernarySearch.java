public class TernarySearch {

  public boolean search(int[] arr, int needle) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int partitionSize = (right - left) / 3;
      int mid1 = left + partitionSize;
      int mid2 = right - partitionSize;
      if (needle == arr[mid1] || needle == arr[mid2]) {
        return true;
      }
      if (needle < arr[mid1]) {
        right = mid1 - 1;
        continue;
      }
      if (needle > arr[mid1] && needle < arr[mid2]) {
        left = mid1 + 1;
        right = mid2 - 1;
        continue;
      }
      left = mid2 + 1;
    }
    return false;
  }

  public boolean searchRecursive(int[] arr, int needle) {
    return searchRecursiveWalk(arr, needle, 0, arr.length - 1);
  }

  private boolean searchRecursiveWalk(int[] arr, int needle, int left, int right) {
    if (left > right) {
      return false;
    }
    int partitionSize = (right - left) / 3;
    int mid1 = left + partitionSize;
    int mid2 = right - partitionSize;
    if (needle == arr[mid1] || needle == arr[mid2]) {
      return true;
    }
    if (needle < arr[mid1]) {
      return searchRecursiveWalk(arr, needle, left, mid1 - 1);
    }
    if (needle > arr[mid1] && needle < arr[mid2]) {
      return searchRecursiveWalk(arr, needle, mid1 + 1, mid2 - 1);
    }
    return searchRecursiveWalk(arr, needle, mid2 + 1, right);
  }
}
