package com.fyuizee.p1046;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public int lastStoneWeight(int[] stones) {
    Queue<Integer> q = new PriorityQueue<>();

    for (int i : stones) {
      q.add(-i);
    }

    while (q.size() > 1) {
      int first = -q.remove();
      int second = -q.remove();

      int res = -Math.abs(first - second);
      if (res != 0) {
        q.add(res);
      }
    }

    return !q.isEmpty() ? -q.remove() : 0;
  }
}
