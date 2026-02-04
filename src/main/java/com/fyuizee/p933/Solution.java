package com.fyuizee.p933;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 */
public class Solution {

  class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
      this.queue = new LinkedList<>();
    }

    public int ping(int t) {
      while (!queue.isEmpty() && t - 3000 > queue.peek()) {
        queue.poll();
      }

      queue.add(t);
      return queue.size();
    }
  }
}
