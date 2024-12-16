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

  public void traversePreOrder() {
    this.traversePreOrderWalk(this.root);
  }

  public void traverseInOrder() {
    this.traverseInOrderWalk(this.root);
  }
  public void traversePostOrder(){
    this.traversePostOrderWalk(this.root);
  }
  private void traversePostOrderWalk(TreeNode curr){
    if (curr == null){
      return;
    }
    this.traversePostOrderWalk(curr.leftChild);
    this.traversePostOrderWalk(curr.rightChild);
    System.out.println(curr.value);
  }

  private void traversePreOrderWalk(TreeNode curr) {
    if (curr == null) {
      return;
    }
    System.out.println(curr.value);
    this.traversePreOrderWalk(curr.leftChild);
    this.traversePreOrderWalk(curr.rightChild);
  }

  private void traverseInOrderWalk(TreeNode curr) {
    if (curr == null) {
      return;
    }
    this.traverseInOrderWalk(curr.leftChild);
    System.out.println(curr.value);
    this.traverseInOrderWalk(curr.leftChild);
  }
}
