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

    if (value < node.value) {
      insert(node.leftChild, value);
    } else {
      insert(node.rightChild, value);
    }
    setHeight(node);
    return node;
  }

  private void setHeight(AVLNode node) {
    node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
  }

  private int getHeight(AVLNode node) {
    return node == null ? -1 : node.height;
  }

  private AVLNode balance(AVLNode node) {
    if (isLeftHeavy(node)) {
      if (getBalanceFactor(node.leftChild) < 0) {
        rotateLeft(node.leftChild);
      }
      return rotateRight(node);

    } else if (isRightHeavy(node)) {
      if (getBalanceFactor(node.rightChild) > 0) {
        rotateRight(node.rightChild);
      }
      return rotateLeft(node);
    }
    return node;
  }

  private AVLNode rotateLeft(AVLNode node) {
    var newRoot = node.rightChild;
    node.rightChild = newRoot.leftChild;
    newRoot.leftChild = node;

    setHeight(node);
    setHeight(newRoot);
    return newRoot;
  }

  private AVLNode rotateRight(AVLNode node) {
    var newRoot = node.leftChild;
    node.leftChild = newRoot.rightChild;
    newRoot.rightChild = node;

    setHeight(node);
    setHeight(newRoot);

    return newRoot;
  }

  private boolean isLeftHeavy(AVLNode node) {
    return getBalanceFactor(node) > 1;
  }

  private boolean isRightHeavy(AVLNode node) {
    return getBalanceFactor(node) < -1;
  }

  private int getBalanceFactor(AVLNode node) {
    return node == null ? 0 : getHeight(node.leftChild) - getHeight(node.rightChild);
  }
}
