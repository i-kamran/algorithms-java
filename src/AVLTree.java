public class AVLTree {
  private class AVLNode {
    private int height;
    private int value;
    private AVLNode leftChild;
    private AVLNode rightChild;

    public AVLNode(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Value: " + value;
    }
  }

  private AVLNode root;

  public void insert(int value) {
    insert(root, value);
  }

  private void insert(AVLNode node, int value) {}
}
