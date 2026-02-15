package com.fyuizee.p703;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  class KthLargest {

    private Queue<Integer> q = new PriorityQueue<>();
    private final int k;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      for (int i : nums) {
        q.add(i);

        if (q.size() > k) {
          q.remove();
        }
      }
    }

    public int add(int val) {
      q.add(val);
      if (q.size() > k) {
        q.remove();
      }

      return q.peek();
    }
  }

}
