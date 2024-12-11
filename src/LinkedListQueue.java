public class LinkedListQueue<T> {

  private class QueueNode<E> {
    private E value;
    private QueueNode<E> next;

    private QueueNode(E item) {
      value = item;
      next = null;
    }
  }

  private QueueNode<T> head;
  private QueueNode<T> tail;
  private int length;

  public LinkedListQueue() {
    this.length = 0;
    this.head = null;
  }

  public void enqueue(T item) {
    var newNode = new QueueNode<>(item);
    if (this.isEmpty()) {
      this.head = this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
    this.length++;
  }

  public T dequeue() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot dequeue an empty queue.");
    }
    this.length--;
    var value = this.head.value;
    if (this.length == 0) {
      this.head = this.tail = null;
    } else {
      var tmp = this.head;
      this.head = this.head.next;
      tmp.next = null;
    }
    return value;
  }

  public T peek() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Cannot dequeue an empty queue.");
    }
    return this.head.value;
  }

  public int size() {
    return this.length;
  }

  public boolean isEmpty() {
    return this.length == 0;
  }
}
