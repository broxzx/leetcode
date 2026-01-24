package com.fyuizee.p1877;

import java.util.Arrays;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {

  }

  public int minPairSum(int[] nums) {
    Arrays.sort(nums);
    int res = -1;

    for (int i = 0; i < nums.length; i++) {
      res = Math.max(res, nums[i] + nums[nums.length - 1 - i]);
    }

    return res;
  }
}
