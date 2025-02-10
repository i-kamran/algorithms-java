import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<T> {
  private class WeightedNode {
    private T label;
    private List<WeightedEdge> edges = new ArrayList<>();

    private WeightedNode(T label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label.toString();
    }

    private void addEdge(WeightedNode to, int weight) {
      edges.add(new WeightedEdge(this, to, weight));
    }

    private List<WeightedEdge> getEdges() {
      return edges;
    }
  }

  private class WeightedEdge {
    private WeightedNode from;
    private WeightedNode to;
    private int weight;

    private WeightedEdge(WeightedNode from, WeightedNode to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return from.toString() + " -> " + to.toString() + ", Weight: " + weight;
    }
  }

  Map<T, WeightedNode> nodes = new HashMap<>();

  public void addNode(T label) {
    nodes.putIfAbsent(label, new WeightedNode(label));
  }

  public void addEdge(T from, T to, int weight) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);

    if (fromNode == null || toNode == null) {
      throw new IllegalArgumentException("Both nodes must exist.");
    }
    fromNode.addEdge(toNode, weight);
    toNode.addEdge(fromNode, weight);
  }

  public void print() {
    for (var node : nodes.values()) {
      System.out.println("Node: " + node.label);
      for (var neighbor : node.getEdges()) {
        System.out.println("    " + neighbor);
      }
    }
  }
}
