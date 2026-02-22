package com.fyuizee.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeUtil {

  public static Node buildGraph(List<List<Integer>> adjList) {
    if (adjList == null || adjList.isEmpty()) {
      return null;
    }

    Map<Integer, Node> map = new HashMap<>();

    for (int i = 0; i < adjList.size(); i++) {
      map.put(i + 1, new Node());
      map.get(i + 1).val = i + 1;
      map.get(i + 1).neighbors = new ArrayList<>();
    }

    for (int i = 0; i < adjList.size(); i++) {
      Node current = map.get(i + 1);
      for (int neighborVal : adjList.get(i)) {
        current.neighbors.add(map.get(neighborVal));
      }
    }

    return map.get(1);
  }
}
