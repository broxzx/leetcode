package com.fyuizee.p502;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.findMaximizedCapital(1, 2, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
  }

  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    Queue<int[]> minCapital = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    Queue<int[]> maxProfit = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

    for (int i = 0; i < profits.length; i++) {
      minCapital.add(new int[] {capital[i], profits[i]});
    }

    while (k-- > 0) {
      while (!minCapital.isEmpty() && w >= minCapital.peek()[0]) {
        maxProfit.add(minCapital.remove());
      }

      if (maxProfit.isEmpty()) {
        break;
      }

      w += maxProfit.remove()[1];
    }


    return w;
  }

}
