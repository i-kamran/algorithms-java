public class LinearSearch {
  public boolean search(int[] arr, int needle) {
    for (var item : arr) {
      if (item == needle) {
        return true;
      }
    }
    return false;
  }
}
