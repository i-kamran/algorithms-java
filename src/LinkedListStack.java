public class LinkedListStack<T> {
  private class StackNode<N> {
    private N value;
    private StackNode<N> prev;

    private StackNode(N item) {
      this.value = item;
      this.prev = null;
    }
  }

  private StackNode<T> head;
  private int length;

  public void push(T item) {
    StackNode<T> newNode = new StackNode<>(item);
    newNode.prev = this.head;
    this.head = newNode;
    this.length++;
  }

  public T pop() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot pop empty stack");
    }
    var node = this.head;
    this.head = this.head.prev;
    node.prev = null;
    this.length--;
    return node.value;
  }

  public boolean isEmpty() {
    return this.length == 0;
  }

  public T peek() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot peek empty stack");
    }
    return this.head.value;
  }
}
