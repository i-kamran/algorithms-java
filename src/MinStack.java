public class MinStack {
  private StackLinkedList<Integer> stack;
  private StackLinkedList<Integer> minStack;

  public MinStack() {
    this.stack = new StackLinkedList<>();
    this.minStack = new StackLinkedList<>();
  }

  public void push(int item) {
    this.stack.push(item);

    if (this.minStack.isEmpty()) {
      this.minStack.push(item);
    } else if (item <= this.minStack.peek()) {
      this.minStack.push(item);
    }
  }

  public int pop() {
    if (this.stack.isEmpty()) {
      throw new IllegalStateException("Cannot pop an empty stack.");
    }
    int value = this.stack.pop();
    if (value == this.minStack.peek()) {
      this.minStack.pop();
    }
    return value;
  }

  public int min() {
    return this.minStack.peek();
  }
}
