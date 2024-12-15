public class Tree {
  private class TreeNode {
    private int value;
    private TreeNode rightChild;
    private TreeNode leftChild;

    private TreeNode(int value) {
      this.value = value;
    }
  }

  private TreeNode root;

  public void insert(int value) {
    var newNode = new TreeNode(value);
    if (this.root == null) {
      this.root = newNode;
      return;
    }
    var curr = root;
    while (true) {
      if (value < curr.value) {
        if (curr.leftChild == null) {
          curr.leftChild = newNode;
          break;
        }
        curr = curr.leftChild;
      } else {
        if (curr.rightChild == null) {
          curr.rightChild = newNode;
          break;
        }
        curr = curr.rightChild;
      }
    }
  }

  public boolean find(int value) {
    if (this.root == null) {
      throw new IllegalStateException("Cannot search an empty tree.");
    }
    var curr = this.root;
    while (curr != null) {
      if (value == curr.value) {
        return true;
      } else if (value > curr.value) {
        curr = curr.rightChild;
      } else {
        curr = curr.leftChild;
      }
    }
    return false;
  }
}
