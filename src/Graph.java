import java.util.HashMap;
import java.util.Map;

public class Graph {
  private class GraphNode {
    String label;

    private GraphNode(String label) {
      this.label = label;
    }
  }

  private Map<String, GraphNode> nodes = new HashMap<>();
  public void addNode(String label) {
    var node = new GraphNode(label);
    nodes.putIfAbsent(label, node);
  }

  public String removeNode(String label) {}

  public void addEdge(String from, String to) {
    var fromNode = nodes.get(from);
    if (fromNode == null) {
      throw new IllegalArgumentException("Not a valid from node.");
    }

    var toNode = nodes.get(to);
    if (toNode == null) {
      throw new IllegalArgumentException("Not a valid to node.");
    }
  }

  public void removeEdge(String from, String to) {}

  public void print() {}
}
