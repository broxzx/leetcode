package com.fyuizee.p1971;

import java.util.*;

public class Solution {

  public boolean validPath(int n, int[][] edges, int source, int destination) {
    if (source == destination) {
      return true;
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.computeIfAbsent(edge[0], integer -> new ArrayList<>()).add(edge[1]);
      map.computeIfAbsent(edge[1], integer -> new ArrayList<>()).add(edge[0]);
    }

    Set<Integer> seen = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    seen.add(source);

    while (!queue.isEmpty()) {
      Integer curNode = queue.remove();

      for (int i : map.getOrDefault(curNode, new ArrayList<>())) {
        if (i == destination) {
          return true;
        }

        if (seen.add(i)) {
          queue.add(i);
        }
      }
    }

    return false;
  }
}
