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

  private boolean isEmpty() {
    return this.head == null;
  }
}
