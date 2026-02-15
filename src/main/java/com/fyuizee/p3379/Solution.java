package com.fyuizee.p3379;

import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    int[] nums = {-1, 4, -1};
    System.out.println(Arrays.toString(constructTransformedArray(nums)));
  }

  public static int[] constructTransformedArray(int[] nums) {
    int len = nums.length;
    int[] res = new int[len];

    for (int i = 0; i < len; i++) {
      int val = nums[i];

      if (val > 0) {
        res[i] = nums[(val + i) % len];
      } else if (val < 0) {
        int index = ((i + val) % len);
        res[i] = nums[index < 0 ? len + index : index];
      } else {
        res[i] = nums[i];
      }
    }

    return res;
  }

}
