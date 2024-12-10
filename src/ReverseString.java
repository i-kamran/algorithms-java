/** Class to reverse a string. String is reversed using a stack. */
public class ReverseString {
  public String reverse(String input) {
    LinkedListStack<Character> stack = new LinkedListStack<>();

    for (char ch : input.toCharArray()) {
      stack.push(ch);
    }
    StringBuffer reversed = new StringBuffer();
    while (!stack.isEmpty()) {
      reversed.append(stack.pop());
    }
    return reversed.toString();
  }
}
