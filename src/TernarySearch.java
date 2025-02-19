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
}
