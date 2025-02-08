import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

  public void removeNode(String label) {
    var node = nodes.get(label);
    if (node == null) {
      return;
    }

    for (var fromNode : adjacencyList.keySet()) {
      adjacencyList.get(fromNode).remove(node);
    }
    adjacencyList.remove(node);
    nodes.remove(label);
  }

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

  public void removeEdge(String from, String to) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    if (fromNode == null || toNode == null) {
      return;
    }
    adjacencyList.get(fromNode).remove(toNode);
  }

  public void print() {
    for (var node : adjacencyList.keySet()) {
      var list = adjacencyList.get(node);
      if (list != null) {
        System.out.println(node + " is connected to " + list);
      }
    }
  }

  public void traverseDepthFirst(String label) {
    Set<GraphNode> seen = new HashSet<>();
    var node = nodes.get(label);
    if (node == null) {
      return;
    }
    traverseDepthWalk(node, seen);
  }

  private void traverseDepthWalk(GraphNode node, Set<GraphNode> seen) {
    System.out.println(node.label);
    seen.add(node);
    for (var toNode : adjacencyList.get(node)) {
      if (!seen.contains(toNode)) {
        traverseDepthWalk(toNode, seen);
      }
    }
  }

  private void traverseDepthFirstRecursive(String label) {
    var node = nodes.get(label);
    if (node == null) {
      return;
    }
    Set<GraphNode> seen = new HashSet<>();

    StackLinkedList<GraphNode> stack = new StackLinkedList<>();
    stack.push(node);
    while (!stack.isEmpty()) {
      var curr = stack.pop();
      if (seen.contains(curr)) {
        continue;
      }
      System.out.println(curr.label);
      seen.add(curr);
      var list = adjacencyList.get(node);
      for (var toNode : list) {
        if (!seen.contains(toNode)) {
          stack.push(toNode);
        }
      }
    }
  }
}
