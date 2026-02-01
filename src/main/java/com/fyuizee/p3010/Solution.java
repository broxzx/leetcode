package com.fyuizee.p3010;

public class Solution {

  public static void main(String[] args) {
    System.out.println(minimumCost(new int[]{1, 2, 3, 12}));
  }

  public static int minimumCost(int[] nums) {
    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length; i++) {
      if (first >= nums[i]) {
        second = first;
        first = nums[i];
      } else if (second >= nums[i]) {
        second = nums[i];
      }
    }

    return nums[0] + first + second;
  }

}
