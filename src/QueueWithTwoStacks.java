public class QueueWithTwoStacks<T> {
StackLinkedList<T> enqueueStack = new StackLinkedList<>();
  StackLinkedList<T> dequeueStack = new StackLinkedList<>();

  public void enqueue(T item) {
    this.enqueueStack.push(item);
  }

  public T dequeue() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot dequeue empty queue");
    }
    if (this.dequeueStack.isEmpty()) {
      moveEnqueueToDequeStack();
    }
    return this.dequeueStack.pop();
  }

  public boolean isEmpty() {
    return this.dequeueStack.isEmpty() && this.enqueueStack.isEmpty();
  }

  public T peek() {

    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot dequeue empty queue");
    }
    if (this.dequeueStack.isEmpty()) {
      moveEnqueueToDequeStack();
    }
    return this.dequeueStack.peek();
  }

  private void moveEnqueueToDequeStack() {
    while (!this.enqueueStack.isEmpty()) {
      this.dequeueStack.push(this.enqueueStack.pop());
    }
  }
}
