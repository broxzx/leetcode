package com.fyuizee.p133;

import com.fyuizee.utils.Node;
import com.fyuizee.utils.NodeUtil;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.cloneGraph(NodeUtil.buildGraph(List.of(List.of(2, 4), List.of(1, 3), List.of(2, 4), List.of(1, 3))));
  }

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }

    Map<Node, Node> map = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    map.put(node, new Node(node.val, new ArrayList<>()));
    queue.add(node);

    while (!queue.isEmpty()) {
      Node cur = queue.remove();

      for (Node n : cur.neighbors) {
        if (!map.containsKey(n)) {
          map.put(n, new Node(n.val, new ArrayList<>()));
          queue.add(n);
        }

        map.get(cur).neighbors.add(map.get(n));
      }
    }

    return map.get(node);
  }
}
