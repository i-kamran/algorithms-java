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
    root = insert(root, value);
  }

  private AVLNode insert(AVLNode node, int value) {
    if (node == null) {
      return new AVLNode(value);
    }
    
  }

  private int getHeight(AVLNode node){
    return node.height;

  }

  private boolean isBalanced(AVLNode node) {}

  private int getHeight(AVLNode node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }
}
