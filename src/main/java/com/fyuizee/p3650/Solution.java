package com.fyuizee.p3650;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {

  }

  public int minCost(int n, int[][] edges) {
    List<int[]>[] grouped = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      grouped[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      int x = edge[0];
      int y = edge[1];
      int w = edge[2];

      grouped[x].add(new int[] { y, w });
      grouped[y].add(new int[] { x, 2 * w });
    }

    int[] res = new int[n];
    boolean[] visited = new boolean[n];
    Arrays.fill(res, Integer.MAX_VALUE);
    res[0] = 0;

    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    queue.offer(new int[] { 0, 0 });

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int dist = current[0];
      int x = current[1];

      if (x == n - 1) {
        return dist;
      }

      if (visited[x]) {
        continue;
      }
      visited[x] = true;

      for (int[] neighbor : grouped[x]) {
        int y = neighbor[0];
        int w = neighbor[1];

        if (dist + w < res[y]) {
          res[y] = dist + w;
          queue.offer(new int[] { res[y], y });
        }
      }

    }
    return -1;
  }
}
