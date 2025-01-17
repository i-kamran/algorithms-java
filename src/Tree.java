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

  public int getMinValueInSearchTree() {
    if (root == null) {
      throw new IllegalStateException("Tree is empty.");
    }
    var curr = root;
    while (curr.leftChild != null) {
      curr = curr.leftChild;
    }
    return curr.value;
  }

  public int getMin() {
    if (root == null) {
      throw new IllegalStateException("Tree is empty.");
    }
    return min(root);
  }

  private int min(TreeNode node) {
    if (isLeaf(node)) {
      return node.value;
    }
    var child = Math.min(min(node.leftChild), min(node.rightChild));
    return Math.min(node.value, child);
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

  public boolean contains(int value) {
    return containsWalk(value, root);
  }

  private boolean containsWalk(int value, TreeNode node) {
    if (node == null) {
      return false;
    }
    if (node.value == value) {
      return true;
    }
    return containsWalk(value, node.leftChild) || containsWalk(value, node.rightChild);
  }

  public void traversePreOrder() {
    this.traversePreOrderWalk(this.root);
  }

  public void traverseInOrder() {
    this.traverseInOrderWalk(this.root);
  }

  public void traversePostOrder() {
    this.traversePostOrderWalk(this.root);
  }

  private void traversePostOrderWalk(TreeNode curr) {
    if (curr == null) {
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

  public int countLeaves() {
    return countLeavesWalk(root);
  }

  private int countLeavesWalk(TreeNode node) {
    if (node == null) {
      return 0;
    }
    if (isLeaf(node)) {
      return 1;
    }
    return countLeavesWalk(node.leftChild) + countLeavesWalk(node.rightChild);
  }

  public int getMax() {

    if (root == null) {
      throw new IllegalStateException("Tree is empty.");
    }

    return getMaxWalk(root);
  }

  private int getMaxWalk(TreeNode node) {
    if (isLeaf(node)) {
      return node.value;
    }
    return Math.max(node.value, Math.max(getMaxWalk(node.leftChild), getMaxWalk(node.rightChild)));
  }

  public int size() {
    if (root == null) {
      throw new IllegalStateException("Tree is empty.");
    }
    return getSize(root);
  }

  private int getSize(TreeNode node) {
    if (node == null) {
      return 0;
    }
    if (isLeaf(node)) {
      return 1;
    }
    return 1 + getSize(node.leftChild) + getSize(node.rightChild);
  }

  public boolean areSibling(int first, int second) {
    return areSiblingWalk(root, first, second);
  }

  private boolean areSiblingWalk(TreeNode node, int first, int second) {
    if (node == null) {
      return false;
    }
    var siblings = false;
    if (node.leftChild != null && node.rightChild != null) {
      siblings = (node.leftChild.value == first && node.rightChild.value == second)
              || (node.leftChild.value == second && node.rightChild.value == first);
    }
    return siblings || areSiblingWalk(node.leftChild, first, second)
        || areSiblingWalk(node.rightChild, first, second);
  }
  public LinkedListGeneric<Integer> getAncestors(int needle){

    var ancestors = new LinkedListGeneric<Integer>();
    getAncestorsWalk(needle, root, ancestors); 
    return ancestors;
  }
  private boolean getAncestorsWalk(int needle, TreeNode node, LinkedListGeneric<Integer> ancestors){
    if (node == null){
      return false;
    }
    if (needle == node.value){
      return true;
    }
    if (getAncestorsWalk(needle, node.leftChild, ancestors) || getAncestorsWalk(needle, node.rightChild , ancestors)){
      ancestors.add(node.value);
      return true;
    }
    return false;


  }

  public int getHeight() {
    if (root == null) {
      return -1;
    }
    return height(root);
  }

  private int height(TreeNode node) {
    if (isLeaf(node)) {
      return 0;
    }
    return 1 + Math.max(height(node.leftChild), height(node.rightChild));
  }

  private boolean isLeaf(TreeNode node) {
    return node.leftChild == null && node.rightChild == null;
  }
}
