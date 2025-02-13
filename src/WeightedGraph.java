import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

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

  private class NodeEntry {
    private WeightedNode node;
    private int priority;

    private NodeEntry(WeightedNode node, int priority) {
      this.node = node;
      this.priority = priority;
    }
  }

  public Path getShortestPath(String from, String to) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    if (fromNode == null || toNode == null) {
      throw new IllegalArgumentException("Both nodes must exist.");
    }

    Map<WeightedNode, Integer> distances = new HashMap<>();
    Map<WeightedNode, WeightedNode> previousNodes = new HashMap<>();
    Set<WeightedNode> visited = new HashSet<>();
    PriorityQueue<NodeEntry> queue =
        new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

    for (var node : nodes.values()) {
      distances.put(node, Integer.MAX_VALUE);
    }

    distances.replace(fromNode, 0);

    queue.add(new NodeEntry(fromNode, 0));

    while (!queue.isEmpty()) {
      var curr = queue.remove().node;

      visited.add(curr);

      for (var edge : curr.getEdges()) {
        if (visited.contains(edge.to)) {
          continue;
        }
        var newDistance = distances.get(curr) + edge.weight;
        if (newDistance < distances.get(edge.to)) {
          distances.replace(edge.to, newDistance);
          previousNodes.put(edge.to, curr);
          queue.add(new NodeEntry(edge.to, newDistance));
        }
      }
    }
    return buildPath(previousNodes, toNode);
  }

  private Path buildPath(Map<WeightedNode, WeightedNode> previousNodes, WeightedNode toNode) {
    Stack<WeightedNode> stack = new Stack<>();
    stack.push(toNode);
    var previous = previousNodes.get(toNode);
    while (previous != null) {
      stack.push(previous);
      previous = previousNodes.get(previous);
    }
    Path path = new Path();
    while (!stack.isEmpty()) {
      path.add(stack.pop().toString());
    }
    return path;
  }

  public boolean hasCycle() {
    Set<WeightedNode> visited = new HashSet<>();
    for (var curr : nodes.values()) {
      if (!visited.contains(curr) && hasCycleWalk(curr, null, visited)) {
        return true;
      }
    }
    return false;
  }

  private boolean hasCycleWalk(WeightedNode curr, WeightedNode parent, Set<WeightedNode> visited) {
    if (visited.contains(curr)) {
      return false;
    }
    visited.add(curr);
    for (var edge : curr.getEdges()) {
      if (edge.to == parent) {
        continue;
      }
      if (visited.contains(edge.to) || hasCycleWalk(edge.to, curr, visited)) {
        return true;
      }
    }
    return false;
  }

  public WeightedGraph<T> getMinimumSpanningTree() {
    WeightedGraph<T> tree = new WeightedGraph<>();
    if (nodes.isEmpty()) {
      return tree;
    }
    PriorityQueue<WeightedEdge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

    var startNode = nodes.values().iterator().next();
    edges.addAll(startNode.getEdges());

    tree.addNode(startNode.label);
    while (tree.nodes.size() < nodes.size()) {
      WeightedEdge minEdge = edges.remove();
      if (tree.containsNode(minEdge.to.label)) {
        continue;
      }
      tree.addNode(minEdge.to.label);
      tree.addEdge(minEdge.from.label, minEdge.to.label, minEdge.weight);

      for (var edge : minEdge.to.getEdges()) {
        if (!tree.containsNode(edge.to.label)) {
          edges.add(edge);
        }
      }
    }
    return tree;
  }

  public boolean containsNode(T label) {
    return nodes.containsKey(label);
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
