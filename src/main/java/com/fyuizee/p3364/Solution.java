package com.fyuizee.p3364;

import java.util.List;

public class Solution {

  public static void main(String[] args) {
//    System.out.println(minimumSumSubarray(List.of(4, -10), 1, 1));
//    System.out.println(minimumSumSubarray(List.of(-2,2,-3,1), 2, 3));
//    System.out.println(minimumSumSubarray(List.of(1, 2, 3, 4), 2, 4));
//    System.out.println(minimumSumSubarray(List.of(7, 3), 2, 2));
    System.out.println(minimumSumSubarray(List.of(-12, 8), 1, 1));
  }

  public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
    int res = Integer.MAX_VALUE;

    for (int right = l; right <= r; right++) {
      int sum = 0;

      for (int i = 0; i < right; i++) {
        sum += nums.get(i);
      }

      if (sum > 0) {
        res = Math.min(sum, res);
      }

      for (int i = 1; i + right - 1 < nums.size(); i++) {
        sum = sum - nums.get(i - 1) + nums.get(i + right - 1);
        if (sum > 0)
          res = Math.min(sum, res);
      }
    }

    return res == Integer.MAX_VALUE ? -1 : res;
  }

}
