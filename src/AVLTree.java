public class AVLTree {
  private class AVLNode {
    private int height;
    private int value;
    private AVLNode leftChild;
    private AVLNode rightChild;

    public AVLNode(int value) {
      this.value = value;
    }
  }
}
