public class StackQueue<T> {
  LinkedListStack<T> enqueu_stack = new LinkedListStack<>();
  LinkedListStack<T> deque_stack = new LinkedListStack<>();

  public void enqueu(T item) {
    this.enqueu_stack.push(item);
  }

  public T dequeu() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot dequeu empty queue");
    }
    if (this.deque_stack.isEmpty()) {
      moveEnqueToDequeStack();
    }
    return this.deque_stack.pop();
  }

  public boolean isEmpty() {
    return this.deque_stack.isEmpty() && this.enqueu_stack.isEmpty();
  }

  public T peek() {

    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot dequeu empty queue");
    }
    if (this.deque_stack.isEmpty()) {
      moveEnqueToDequeStack();
    }
    return this.deque_stack.peek();
  }

  private void moveEnqueToDequeStack() {
    while (!this.enqueu_stack.isEmpty()) {
      this.deque_stack.push(this.enqueu_stack.pop());
    }
  }
}
