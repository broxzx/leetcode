package com.fyuizee.p57;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.insert(new int[][]{{0, 2}, {3, 9}}, new int[]{6, 8}));
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) {
      return new int[][]{newInterval};
    }

    int len = intervals.length;
    List<int[]> list = new ArrayList<>();

    int i = 0;
    while (i < len && intervals[i][1] < newInterval[0]) {
      list.add(intervals[i++]);
    }

    while (i < len && newInterval[1] >= intervals[i][0]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }
    list.add(newInterval);

    while (i < len) {
      list.add(intervals[i++]);
    }

    return list.toArray(new int[list.size()][]);
  }
}
