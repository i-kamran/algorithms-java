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
}
