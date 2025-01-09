public class QueueReverser {
  public static void reverse(QueueArray queue, int k) {
    if (k < 0 || k > queue.length) {
      throw new IllegalStateException("Provide k within bounds.");
    }
    StackLinkedList<Integer> stack = new StackLinkedList<>();
    for (int i = 0; i < k; ++i) {
      stack.push(queue.dequeue());
    }

    while (!stack.isEmpty()) {
      queue.enqueue(stack.pop());
    }
    for (int i = queue.length; i > k; --i) {
      queue.enqueue(queue.dequeue());
    }
  }
}
