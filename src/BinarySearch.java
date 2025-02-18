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
  private static void testSearchMethods(BinarySearch searcher, int[] arr, int target) {
    System.out.println("Searching for " + target + "...");
    System.out.println("Iterative search: " + searcher.search(arr, target));
    System.out.println("Recursive search: " + searcher.searchRecursive(arr, target));
    System.out.println("-------------------------");
  }
}
