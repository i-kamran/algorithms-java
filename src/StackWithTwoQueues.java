public class StackWithTwoQueues<T> {
  private QueueLinkedList<T> pushQueue = new QueueLinkedList<>();
  private QueueLinkedList<T> popQueue = new QueueLinkedList<>();
  private int length;

  public void push(T item) {
    pushQueue.enqueue(item);
    this.length++;
  }

  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Cannot pop an empty stack.");
    }
    if (this.popQueue.isEmpty()) {
      this.movePushToPopQueue();
    }
    this.length--;
    this.swapQueues();
    return this.popQueue.dequeue();
  }

  public boolean isEmpty() {
    return this.length == 0;
  }

  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Cannot peek an empty stack.");
    }
    if (popQueue.isEmpty()) {
      this.movePushToPopQueue();
    }
    return this.popQueue.peek();
  }

  private void movePushToPopQueue() {
    while (this.pushQueue.size() > 1) {
      this.popQueue.enqueue(this.pushQueue.dequeue());
    }
  }
  private void swapQueues(){
    var temp = this.pushQueue;
    this.pushQueue = this.popQueue;
    this.popQueue = temp;
  }
}
