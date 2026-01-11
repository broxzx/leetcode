package com.fyuizee.p1004;

public class Solution {

  public static void main(String[] args) {
    System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
  }

  public static int longestOnes(int[] nums, int k) {
    int left = 0, res = 0, zeroCount = 0;

    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        zeroCount++;
      }

      while (zeroCount > k) {
        if (nums[left] == 0) {
          zeroCount--;
        }
        left++;
      }

      res = Math.max(res, right - left + 1);
    }

    return res;
  }
}
