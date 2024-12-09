import java.util.NoSuchElementException;

public class LinkedList {
  private class Node {
    private int value;
    private Node next;

    /**
     * Constructor to initialize the node with a value.
     *
     * @param value the value to assign to this node
     */
    public Node(int value) {
      this.value = value;
    }
  }

  private Node head;
  private Node tail;

  public void addLast(int item) {
    var node = new Node(item);
    if (this.isEmpty()) {
      this.head = this.tail = node;
    } else {
      this.tail.next = node;
      this.tail = node;
    }
  }

  public void addFirst(int item) {
    var node = new Node(item);
    if (this.isEmpty()) {
      this.head = this.tail = node;
    } else {
      node.next = this.head;
      this.head = node;
    }
  }

  public int removeFirst() {
    if (isEmpty()) throw new NoSuchElementException();
    var value = this.head.value;
    var second = this.head.next;
    this.head.next = null;
    this.head = second;
    if (this.isEmpty()) {
      this.tail = null;
    }
    return value;
  }

  public int removeLast() {
    if (this.isEmpty()) {
      throw new NoSuchElementException();
    }
    var value = this.tail.value;
    var prev = getPrevious(this.tail);
    this.tail = prev;
    this.tail.next = null;
    return value;
  }

  private Node getPrevious(Node node) {
    var curr = this.head;
    while (curr != null) {
      if (curr.next == node) {
        return curr;
      }
      curr = curr.next;
    }
    return null;
  }

  public int indexOf(int item) {
    var curr = this.head;
    for (var i = 0; curr != null; ++i) {
      if (curr.value == item) {
        return i;
      }
      curr = curr.next;
    }
    return -1;
  }

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  private boolean isEmpty() {
    return this.head == null;
  }
}
