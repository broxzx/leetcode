package com.fyuizee.p1962;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public int minStoneSum(int[] piles, int k) {
    Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

    int res = 0;
    for (int i : piles) {
      res += i;
      queue.add(i);
    }

    while (k-- > 0) {
      Integer i = queue.remove();
      res -= i;
      i = (int) Math.ceil((double) i / 2);
      res += i;
      queue.add(i);
    }

    return res;
  }
}
