public class JumpSearch {
  public boolean search(int[] arr, int needle) {
    int blockSize = (int) Math.sqrt(arr.length);
    int i;
    for (i = blockSize; i < arr.length; i += blockSize) {
      if (needle < arr[i]) {
        for (int j = i - blockSize; j < i; ++j) {
          if (needle == arr[j]) {
            return true;
          }
        }
        return false;
      }
    }
    // Handle the last block
    for (int j = i - blockSize; j < arr.length; ++j) {
      if (arr[j] == needle) {
        return true;
      }
    }

    return false;
  }
}
