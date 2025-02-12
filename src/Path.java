import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Path implements Iterable<String> {
  private List<String> nodes = new ArrayList<>();

  public void add(String node) {
    nodes.add(node);
  }

  @Override
  public Iterator<String> iterator() {
    return nodes.iterator();
  }

  @Override
  public String toString() {
    return nodes.toString();
  }
}

