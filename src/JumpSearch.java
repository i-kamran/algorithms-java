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

  public static void main(String[] args) {
    JumpSearch js = new JumpSearch();

    int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println("Test 1: Search for 5 in arr1");
    System.out.println("Expected: true");
    System.out.println("Result: " + js.search(arr1, 5));

    System.out.println("\nTest 2: Search for 11 in arr1");
    System.out.println("Expected: false");
    System.out.println("Result: " + js.search(arr1, 11));

    int[] arr2 = new int[20];
    for (int i = 0; i < 20; i++) {
      arr2[i] = i * 2;
    }
    System.out.println("\nTest 3: Search for 14 in arr2");
    System.out.println("Expected: true");
    System.out.println("Result: " + js.search(arr2, 14));

    // Test case 4: Edge case - first element
    System.out.println("\nTest 4: Search for 0 in arr2");
    System.out.println("Expected: true");
    System.out.println("Result: " + js.search(arr2, 0));

    // Test case 5: Edge case - last element
    System.out.println("\nTest 5: Search for 38 in arr2");
    System.out.println("Expected: true");
    System.out.println("Result: " + js.search(arr2, 38));
  }
}
