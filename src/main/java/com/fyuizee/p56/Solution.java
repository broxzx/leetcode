package com.fyuizee.p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.merge(new int[][]{{5, 5}, {1, 3}, {3, 5}, {4, 6}, {1, 1}, {3, 3}, {5, 6}, {3, 3}, {2, 4}, {0, 0}});
  }

  public int[][] merge(int[][] intervals) {
    List<int[]> list = new ArrayList<>();
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    int len = intervals.length;
    for (int i = 0; i < len; ) {
      int k = i;
      int max = intervals[i][1];
      while (k + 1 < len && max >= intervals[k + 1][0]) {
        k++;
        max = Math.max(max, intervals[k][1]);
      }

      if (k < len) {
        list.add(new int[]{intervals[i][0], max});
      }
      i = k + 1;
    }

    int[][] res = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i);
    }

    return res;
  }
}
