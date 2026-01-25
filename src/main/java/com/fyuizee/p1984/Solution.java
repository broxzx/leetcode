package com.fyuizee.p1984;

import java.util.Arrays;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    System.out
        .println(
            minimumDifference(
                new int[] { 9, 4, 1, 7 },
                2));
  }

  public static int minimumDifference(int[] nums, int k) {
    if (k <= 1) {
      return 0;
    }
    Arrays.sort(nums);
    int res = Integer.MAX_VALUE;

    for (int i = 0; i <= nums.length - k; i++) {
      res = Math.min(res, nums[i + k - 1] - nums[i]);
    }

    return res;
  }
}
