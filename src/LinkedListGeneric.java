import java.util.Iterator;

public class LinkedListGeneric<T> implements Iterable<T> {
  private class GenericNode<E> {
    E value;
    GenericNode<E> next;

    private GenericNode(E value) {
      this.value = value;
      next = null;
    }
  }

  public int length;
  private GenericNode<T> head;
  private GenericNode<T> tail;

  public LinkedListGeneric() {
    length = 0;
    head = tail = null;
  }

  public void add(T value) {
    var newNode = new GenericNode<>(value);
    if (isEmpty()) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  public T remove() {
    if (isEmpty()) {
      throw new IllegalStateException("Cannot remove from an empty list.");
    }
    length--;
    var node = head;
    head = head.next;
    if (head == null) {
      tail = head = null;
    }
    return node.value;
  }


  public void print() {
    var curr = head;
    while (curr != null) {
      System.out.println(curr.value);
      curr = curr.next;
    }
  }

  private boolean isEmpty() {
    return head == null;
  }

  // Implementing Iterable<T>
  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  // Inner class to implement Iterator<T>
  private class LinkedListIterator implements Iterator<T> {
    private GenericNode<T> current = head;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      T value = current.value;
      current = current.next;
      return value;
    }
  }
}
