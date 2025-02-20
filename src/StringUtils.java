import java.util.HashSet;
import java.util.Set;

public class StringUtils {
  public static int countVowels(String str) {
    if (str == null) {
      return 0;
    }
    int count = 0;
    Set<Character> vowels = new HashSet<>();
    for (char ch : "aeiou".toCharArray()) {
      vowels.add(ch);
    }
    for (var ch : str.toLowerCase().toCharArray()) {
      if (vowels.contains(ch)) {
        count++;
      }
    }
    return count;
  }

  public static String reverse(String str) {
    if (str == null) {
      return "";
    }
    StringBuilder reversed = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; --i) {
      reversed.append(str.charAt(i));
    }
    return reversed.toString();
  }

  public static String reverseWords(String sentence) {
    String[] words = sentence.split(" ");
    StringBuilder reversed = new StringBuilder();
    for (var i = words.length - 1; i >= 0; --i) {
      reversed.append(words[i] + " ");
    }
    return reversed.toString();
  }

  public static String removeDuplicates(String str) {
    StringBuilder output = new StringBuilder();
    Set<Character> seen = new HashSet<>();
    for (var ch : str.toCharArray()) {
      if (!seen.contains(ch)) {
        seen.add(ch);
        output.append(ch);
      }
    }
    return output.toString();
  }

  public static char getMaxOccurring(String str) {
    if (str == null) {
      return ' ';
    }
    final int ASCII_SIZE = 256;
    int[] frequencies = new int[ASCII_SIZE];
    for (var ch : str.toCharArray()) {
      frequencies[ch]++;
    }
    int max = frequencies[0];
    char value = ' ';
    for (var i = 0; i < frequencies.length; ++i) {
      if (max < frequencies[i]) {
        max = frequencies[i];
        value = (char) i;
      }
    }
    return value;
  }
}
