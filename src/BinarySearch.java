public class BinarySearch {
  public boolean search(int[] arr, int needle) {
    if (arr.length < 1) {
      return false;
    }
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      System.out.println(mid);
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

  public static void main(String[] args) {
    BinarySearch searcher = new BinarySearch();
    int[] arr = {1, 4, 7, 9, 11, 15};
    System.out.println(searcher.search(arr, 5));
  }
}
