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
  private int length;

  public LinkedList() {
    this.length = 0;
    this.head = this.tail = null;
  }

  public void addLast(int item) {
    var node = new Node(item);
    if (this.isEmpty()) {
      this.head = this.tail = node;
    } else {
      this.tail.next = node;
      this.tail = node;
    }
    this.length++;
  }

  public void addFirst(int item) {
    var node = new Node(item);
    if (this.isEmpty()) {
      this.head = this.tail = node;
    } else {
      node.next = this.head;
      this.head = node;
    }
    this.length++;
  }

  public int removeFirst() {
    if (isEmpty()) throw new NoSuchElementException();
    var value = this.head.value;
    if (this.head == this.tail) {
      this.head = this.tail = null;
    } else {
      var second = this.head.next;
      this.head.next = null;
      this.head = second;
    }
    this.length--;
    return value;
  }

  public int removeLast() {
    if (this.isEmpty()) {
      throw new NoSuchElementException();
    }
    var value = this.tail.value;
    if (this.head == this.tail) {
      this.head = this.tail = null;
    } else {
      var prev = getPrevious(this.tail);
      this.tail = prev;
      this.tail.next = null;
    }
    this.length--;
    return value;
  }

  public int getSize() {
    return this.length;
  }

  public int[] toArray() {
    int[] arr = new int[this.length];
    var curr = this.head;
    for (var i = 0; i < this.length; i++, curr = curr.next) {
      arr[i] = curr.value;
    }
    return arr;
  }

  public void reverse() {
    if (this.isEmpty()) {
      throw new NoSuchElementException();
    }
    if (this.head == this.tail) {
      return;
    }
    var curr = this.head;
    Node prev = null;
    while (curr != null) {
      var next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    this.tail = this.head;
    this.head = prev;
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

  public void print() {
    if (this.head == null) {
      System.out.println("Empty List");
      return;
    }
    var curr = this.head;
    while (curr != null) {
      System.out.println(curr.value);
      curr = curr.next;
    }
  }

  public int getKthFromTheEnd(int k) {
    if (k > this.length) {
      throw new IllegalArgumentException();
    }
    var curr = this.head;
    for (int i = 0; i < this.length - k; ++i) {
      curr = curr.next;
    }
    return curr.value;
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

  private boolean isEmpty() {
    return this.head == null;
  }
}
