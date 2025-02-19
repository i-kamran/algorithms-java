import java.util.HashSet;
import java.util.Set;

public class StringUtils{
  public static int countVowels(String str){
    if (str == null) {
      return 0;
    }
    int count = 0;
    Set<Character> vowels = new HashSet<>();
      for (char ch: "aeiou".toCharArray()){
      vowels.add(ch);
    }
    for (var ch: str.toLowerCase().toCharArray()){
      if (vowels.contains(ch)){
        count++;
      }
    }
    return count;
  }
}
