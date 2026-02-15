package com.fyuizee.p215;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public int findKthLargest(int[] nums, int k) {
    Queue<Integer> q = new PriorityQueue<>(k);
    for (int i : nums) {
      q.add(i);
      if (q.size() > k) {
        q.remove();
      }
    }

    return q.remove();
  }

}
