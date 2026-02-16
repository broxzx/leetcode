package com.fyuizee.p57;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}));
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) {
      return new int[][]{newInterval};
    }

    List<int[]> list = new ArrayList<>();
    list.add(new int[]{intervals[0][0], intervals[0][1]});

    if (intervals.length == 1 && newInterval.length == 2) {
      int[] last = list.get(list.size() - 1);
      if (newInterval[1] >= last[1] && newInterval[0] <= last[0]) {
        last[1] = Math.max(last[1], newInterval[1]);
        last[0] = Math.min(last[0], newInterval[0]);
        newInterval[0] = Integer.MAX_VALUE;
        newInterval[1] = Integer.MAX_VALUE;
      } else {
        list.add(new int[]{newInterval[0], newInterval[1]});
      }
    }


    for (int i = 1; i < intervals.length; i++) {
      int[] last = list.get(list.size() - 1);
      if (last[1] >= newInterval[0]) {
        last[1] = Math.max(last[1], newInterval[1]);
        last[0] = Math.min(last[0], newInterval[0]);
        newInterval[0] = Integer.MAX_VALUE;
        newInterval[1] = Integer.MAX_VALUE;
        i--;
      } else if (last[1] >= intervals[i][0]) {
        last[1] = Math.max(last[1], intervals[i][1]);
      } else {
        list.add(new int[]{intervals[i][0], intervals[i][1]});
      }
    }

    return list.toArray(new int[0][0]);
  }
}
