import java.util.Arrays;
import java.util.List;

public class Expressions {
  private List<Character> opening = Arrays.asList('(', '[', '{', '<');
  private List<Character> closing = Arrays.asList(')', ']', '}', '>');

  public boolean isBalanced(String input) {
    StackLinkedList<Character> stack = new StackLinkedList<>();
    for (char ch : input.toCharArray()) {
      if (isOpening(ch)) {
        stack.push(ch);
      }
      if (isClosing(ch)) {
        if (stack.isEmpty()) {
          return false;
        }
        var top = stack.pop();
        if (mapping(ch) != top) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  private char mapping(char ch) {
    switch (ch) {
      case ')':
        return '(';
      case '}':
        return '{';
      case ']':
        return '[';
      case '>':
        return '<';
      default:
        return ' ';
    }
  }

  private boolean isOpening(Character ch) {
    return opening.contains(ch);
  }

  private boolean isClosing(Character ch) {
    return closing.contains(ch);
  }
}
