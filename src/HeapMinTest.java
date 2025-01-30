public class HeapMinTest {
  private static int testsPassed = 0;
  private static int totalTests = 0;

  private static void assertEquals(String expected, String actual, String message) {
    totalTests++;
    if (expected.equals(actual)) {
      System.out.println("✓ " + message);
      testsPassed++;
    } else {
      System.out.println("✗ " + message);
      System.out.println("  Expected: " + expected);
      System.out.println("  Got: " + actual);
    }
  }

  private static void assertTrue(boolean condition, String message) {
    totalTests++;
    if (condition) {
      System.out.println("✓ " + message);
      testsPassed++;
    } else {
      System.out.println("✗ " + message);
      System.out.println("  Expected true, but got false");
    }
  }

  private static void testInsert() {
    System.out.println("\nTesting insert and peek...");
    HeapMin heap = new HeapMin();

    heap.insert(5, "five");
    assertEquals("five", heap.peek(), "First inserted element should be at root");

    heap.insert(3, "three");
    assertEquals("three", heap.peek(), "Min element should be at root after insert");

    heap.insert(7, "seven");
    assertEquals("three", heap.peek(), "Min element should remain at root");
  }

  private static void testRemove() {
    System.out.println("\nTesting remove...");
    HeapMin heap = new HeapMin();

    heap.insert(5, "five");
    heap.insert(3, "three");
    heap.insert(7, "seven");
    heap.insert(1, "one");

    assertEquals("one", heap.remove(), "Should remove smallest element first");
    assertEquals("three", heap.peek(), "Second smallest should now be at root");
    assertEquals("three", heap.remove(), "Should remove new smallest element");
    assertEquals("five", heap.remove(), "Should remove next smallest element");
    assertEquals("seven", heap.remove(), "Should remove last element");
  }

  private static void testCapacityGrowth() {
    System.out.println("\nTesting capacity growth...");
    HeapMin heap = new HeapMin(2); // Start with small capacity

    // Insert more elements than initial capacity
    heap.insert(3, "three");
    heap.insert(2, "two");
    heap.insert(1, "one"); // This should trigger growth

    assertEquals("one", heap.remove(), "Should get smallest after growth");
    assertEquals("two", heap.remove(), "Should get second smallest after growth");
    assertEquals("three", heap.remove(), "Should get third smallest after growth");
  }

  private static void testEmptyHeap() {
    System.out.println("\nTesting empty heap operations...");
    HeapMin heap = new HeapMin();

    assertTrue(heap.isEmpty(), "New heap should be empty");

    try {
      heap.peek();
      System.out.println("✗ peek() should throw exception on empty heap");
    } catch (IllegalStateException e) {
      System.out.println("✓ peek() correctly threw exception on empty heap");
      testsPassed++;
    }
    totalTests++;

    try {
      heap.remove();
      System.out.println("✗ remove() should throw exception on empty heap");
    } catch (IllegalStateException e) {
      System.out.println("✓ remove() correctly threw exception on empty heap");
      testsPassed++;
    }
    totalTests++;
  }

  public static void main(String[] args) {
    try {
      testInsert();
      testRemove();
      testCapacityGrowth();
      testEmptyHeap();

      System.out.println("\nTest Results:");
      System.out.println("Passed: " + testsPassed + "/" + totalTests + " tests");
      if (testsPassed == totalTests) {
        System.out.println("All tests passed!");
      } else {
        System.out.println("Some tests failed.");
        System.exit(1);
      }
    } catch (Exception e) {
      System.out.println("\nUnexpected error during tests:");
      e.printStackTrace();
      System.exit(1);
    }
  }
}
