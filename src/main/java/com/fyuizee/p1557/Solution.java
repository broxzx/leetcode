package com.fyuizee.p1557;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.findSmallestSetOfVertices(6, List.of(List.of(0, 1), List.of(0, 2), List.of(2, 5), List.of(3, 4), List.of(4, 2)));
  }

  public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    boolean[] achievable = new boolean[n];

    for (List<Integer> edge : edges) {
      achievable[edge.get(1)] = true;
    }

    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < achievable.length; i++) {
      if (!achievable[i]) {
        res.add(i);
      }
    }

    return res;
  }
}
