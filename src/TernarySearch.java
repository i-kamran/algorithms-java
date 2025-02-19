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

  public static void main(String[] args) {
    TernarySearch searcher = new TernarySearch();
    int[] arr = {1, 4, 7, 9, 11, 15};

    // Test cases for both methods
    testSearchMethods(searcher, arr, 7); // Present in array
    testSearchMethods(searcher, arr, 5); // Not in array
    testSearchMethods(searcher, arr, 1); // First element
    testSearchMethods(searcher, arr, 15); // Last element
    testSearchMethods(searcher, arr, -1); // Not in array (too low)
    testSearchMethods(searcher, arr, 20); // Not in array (too high)

    // Edge cases
    int[] singleElementArr = {10};
    testSearchMethods(searcher, singleElementArr, 10); // Only element in array
    testSearchMethods(searcher, singleElementArr, 5); // Not in array

    int[] emptyArr = {};
    testSearchMethods(searcher, emptyArr, 3); // Searching in an empty array
  }

  // Helper method to test both search methods
  private static void testSearchMethods(TernarySearch searcher, int[] arr, int target) {
    System.out.println("Searching for " + target + "...");
    System.out.println("Iterative search: " + searcher.search(arr, target));
    System.out.println("Recursive search: " + searcher.searchRecursive(arr, target));
    System.out.println("-------------------------");
  }
}
