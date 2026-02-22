package com.fyuizee.p547;

import java.util.*;

public class Solution {

  public int findCircleNum(int[][] isConnected) {
    Map<Integer, List<Integer>> map = new HashMap<>();

    int len = isConnected.length;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (isConnected[i][j] == 1) {
          map.computeIfAbsent(i, unused -> new ArrayList<>()).add(j);
        }
      }
    }

    int count = 0;
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < len; i++) {
      if (seen.add(i)) {
        count++;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(i);
        while (!queue.isEmpty()) {
          Integer cur = queue.remove();
          List<Integer> nodes = map.get(cur);

          for (int j : nodes) {
            if (seen.add(j)) {
              queue.add(j);
            }
          }
        }
      }
    }

    return count;
  }
}
