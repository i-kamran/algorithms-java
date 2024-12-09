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
    if (this.head == null) {
      this.head = this.tail = node;
    } else {
      this.tail.next = node;
    }
  }
}
