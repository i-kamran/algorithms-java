import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
  public static int ALPHABET_SIZE = 26;

  private class TrieNode {
    private char value;
    private HashMap<Character, TrieNode> children;
    private boolean isEndOfWord;

    private TrieNode(char value) {
      this.value = value;
      children = new HashMap<>();
    }

    @Override
    public String toString() {
      return "value=" + value;
    }

    private boolean hasChild(char ch) {
      return children.containsKey(ch);
    }

    private void addChild(char ch) {
      children.put(ch, new TrieNode(ch));
    }

    private TrieNode getChild(char ch) {
      return children.get(ch);
    }

    private TrieNode[] getChildren() {
      return children.values().toArray(new TrieNode[0]);
    }

    private boolean hasChildren() {
      return !children.isEmpty();
    }

    private void removeChild(char ch) {
      children.remove(ch);
    }
  }

  TrieNode root = new TrieNode(' ');

  public void insert(String word) {
    var current = root;
    for (char ch : word.toCharArray()) {
      if (!current.hasChild(ch)) {
        current.addChild(ch);
      }
      current = current.getChild(ch);
    }
    current.isEndOfWord = true;
  }

  public boolean contains(String word) {
    if (word == null) {
      return false;
    }
    TrieNode curr = root;
    for (char ch : word.toCharArray()) {
      if (!curr.hasChild(ch)) {
        return false;
      }
      curr = curr.getChild(ch);
    }
    return curr.isEndOfWord;
  }

  public boolean containsRecursive(String word) {
    if (word == null) {
      return false;
    }
    return containsRecursiveWalk(root, word, 0);
  }

  private boolean containsRecursiveWalk(TrieNode node, String word, int idx) {
    if (idx == word.length()) {
      return node.isEndOfWord;
    }
    if (node == null) {
      return false;
    }
    var ch = word.charAt(idx);
    var child = node.getChild(ch);
    if (child == null) {
      return false;
    }
    return containsRecursiveWalk(child, word, idx + 1);
  }

  public void remove(String word) {
    if (word == null) {
      return;
    }
    removeWalk(root, word, 0);
  }

  private void removeWalk(TrieNode node, String word, int idx) {
    if (word.length() == idx) {
      node.isEndOfWord = false;
      return;
    }
    var child = node.getChild(word.toCharArray()[idx]);

    if (child == null) {
      return;
    }
    removeWalk(child, word, idx + 1);
    if (!child.hasChildren() && !child.isEndOfWord) {
      node.removeChild(child.value);
    }
  }

  public void traverse() {
    traverseWalk(root);
  }

  private void traverseWalk(TrieNode node) {
    System.out.println(node.value);
    for (var child : root.getChildren()) {
      traverseWalk(child);
    }
  }

  public List<String> autoComplete(String prefix) {
    var lastNode = getLastNode(root, prefix);
    List<String> words = new ArrayList<>();
    autoCompleteWalk(prefix, lastNode, words);
    return words;
  }

  private TrieNode getLastNode(TrieNode node, String prefix) {
    if (node == null) {
      return null;
    }
    for (char ch : prefix.toCharArray()) {
      var child = node.getChild(ch);
      if (child == null) {
        return null;
      }
      node = child;
    }
    return node;
  }

  private void autoCompleteWalk(String prefix, TrieNode node, List<String> words) {
    if (node == null) {
      return;
    }
    if (node.isEndOfWord) {
      words.add(prefix);
    }
    for (var child : node.getChildren()) {
      autoCompleteWalk(prefix + child.value, child, words);
    }
  }
}
