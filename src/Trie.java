import java.util.HashMap;

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
}
