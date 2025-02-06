import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
  private class GraphNode {
    String label;

    private GraphNode(String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label;
    }
  }

  private Map<String, GraphNode> nodes = new HashMap<>();
  private Map<GraphNode, List<GraphNode>> adjacencyList = new HashMap<>();

  public void addNode(String label) {
    var node = new GraphNode(label);
    nodes.putIfAbsent(label, node);
    adjacencyList.putIfAbsent(node, new ArrayList<>());
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
    adjacencyList.get(fromNode).add(toNode);
  }

  public void removeEdge(String from, String to) {}

  public void print() {
    for (var node : adjacencyList.keySet()) {
      var list = adjacencyList.get(node);
      if (list != null) {
        System.out.println(node + " is connected to " + list);
      }
    }
  }
}
