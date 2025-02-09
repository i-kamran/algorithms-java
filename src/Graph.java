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

  public void traverseDepthFirstIterative(String label) {
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
      for (var neighbor : adjacencyList.get(curr)) {
        if (!seen.contains(neighbor)) {
          stack.push(neighbor);
        }
      }
    }
  }

  public void traversalBreadthFirst(String label) {
    var node = nodes.get(label);
    if (node == null) {
      return;
    }
    QueueLinkedList<GraphNode> queue = new QueueLinkedList<>();
    queue.enqueue(node);
    traversalBreadthWalk(queue, new HashSet<GraphNode>());
  }

  private void traversalBreadthWalk(QueueLinkedList<GraphNode> queue, Set<GraphNode> visited) {
    if (queue.isEmpty()) {
      return;
    }
    var curr = queue.dequeue();
    System.out.println(curr.label);
    visited.add(curr);

    for (var toNode : adjacencyList.get(curr)) {
      if (!visited.contains(toNode)) {
        queue.enqueue(toNode);
      }
    }
    traversalBreadthWalk(queue, visited);
  }

  public List<String> topologicalSort(String label) {
    var node = nodes.get(label);
    List<String> result = new ArrayList<String>();
    if (node == null) {
      return result;
    }
    var seen = new HashSet<GraphNode>();
    StackLinkedList<GraphNode> stack = new StackLinkedList<>();
    topologicalSortWalk(node, seen, stack);
    while (!stack.isEmpty()) {
      result.add(stack.pop().label);
    }

    return result;
  }

  private void topologicalSortWalk(
      GraphNode node, HashSet<GraphNode> seen, StackLinkedList<GraphNode> stack) {
    if (node == null || seen.contains(node)) {
      return;
    }
    seen.add(node);

    for (var neighbor : adjacencyList.get(node)) {
      if (seen.contains(neighbor)) {
        continue;
      }
      topologicalSortWalk(neighbor, seen, stack);
    }
    stack.push(node);
  }

  public boolean hasCycle() {
    for (var node : nodes.values()) {
      if (hasCycleWalk(node, new HashSet<>(), new HashSet<>())) {
        return true;
      }
    }
    return false;
  }

}
