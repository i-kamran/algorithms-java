public class Trie {
  public static int ALPHABET_SIZE = 26;

  private class TrieNode {
    private char value;
    private TrieNode[] children;
    private boolean isEndOfWord;

    private TrieNode(char value) {
      this.value = value;
      children = new TrieNode[ALPHABET_SIZE];
    }
  }

  TrieNode root = new TrieNode(' ');

  public void insert(String word) {
    var current = root;
    for (char ch : word.toCharArray()) {
      int idx = ch - 'a';
      if (current.children[idx] == null) {
        current.children[idx] = new TrieNode(ch);
      }
      current = current.children[idx];
    }
    current.isEndOfWord = true;
  }
}
