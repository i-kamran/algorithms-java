import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<T> {
  private class WeightedNode<E> {
    private E label;

    private WeightedNode(E label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label.toString();
    }
  }

  private class WeightedEdge {
    private WeightedNode<T> from;
    private WeightedNode<T> to;
    private int weight;

    private WeightedEdge(WeightedNode<T> from, WeightedNode<T> to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return "To node: " + to.toString() + ", Weight: " + weight;
    }
  }

  Map<T, WeightedNode<T>> nodes = new HashMap<>();
  Map<WeightedNode<T>, List<WeightedEdge>> adjList = new HashMap<>();

  public void addNode(T label) {
    WeightedNode<T> node = new WeightedNode<T>(label);
    nodes.putIfAbsent(label, node);
    adjList.putIfAbsent(node, new ArrayList<>());
  }

  public void addEdge(T from, T to, int weight) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);

    if (fromNode == null || toNode == null) {
      throw new IllegalArgumentException("Both nodes must exist.");
    }
    var edge = new WeightedEdge(fromNode, toNode, weight);
    adjList.get(fromNode).add(edge);
  }

  public void print() {
    for (var node : adjList.keySet()) {
      System.out.println("Node: " + node.label);
      for (var neighbor : adjList.get(node)) {
        System.out.println("    " + neighbor);
      }
    }
  }
}
