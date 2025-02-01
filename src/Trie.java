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

  public List<String> autoComplete(String prefix) {
    if (prefix == null) {
      return null;
    }
    var lastNode = findLastNode(prefix);
    if (lastNode == null) {
      return null;
    }
    List<String> words = new ArrayList<>();
    autoCompleteWalk(prefix, root, words);
    return words;
  }

  private void autoCompleteWalk(String prefix, TrieNode node, List<String> words) {
    if (node == null) {
      return;
    }
    if (node.isEndOfWord) {
      words.add(prefix);
    }
    for (var child : root.getChildren()) {
      autoCompleteWalk(prefix + child.value, node, words);
    }
  }

  private TrieNode findLastNode(String prefix) {
    var curr = root;
    for (char ch : prefix.toCharArray()) {
      var child = curr.getChild(ch);
      if (child == null) {
        return null;
      }
      curr = child;
    }
    return curr;
  }

  private void traverseWalk(TrieNode node) {
    System.out.println(node.value);
    for (var child : root.getChildren()) {
      traverseWalk(child);
    }
  }
}
