public class BinarySearch {
  public boolean search(int[] arr, int needle) {
    if (arr.length < 1) {
      return false;
    }
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (needle == arr[mid]) {
        return true;
      }
      if (needle < arr[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }

  public boolean searchRecursive(int[] arr, int needle) {
    return searchWalk(arr, needle, 0, arr.length - 1);
  }

  private boolean searchWalk(int[] arr, int needle, int left, int right) {
    if (left > right) {
      return false;
    }
    int mid = left + (right - left) / 2;
    if (needle == arr[mid]) {
      return true;
    }
    if (needle < arr[mid]) {
      return searchWalk(arr, needle, left, mid - 1);
    } else {
      return searchWalk(arr, needle, mid + 1, right);
    }
  }

  public static void main(String[] args) {
    BinarySearch searcher = new BinarySearch();
    int[] arr = {1, 4, 7, 9, 11, 15};
  }
}
