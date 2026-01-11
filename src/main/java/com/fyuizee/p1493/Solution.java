package com.fyuizee.p1493;

public class Solution {

  public static void main(String[] args) {
    System.out.println(longestSubarray(new int[] {1,1,0,1}));
  }

  public static int longestSubarray(int[] nums) {
    int left = 0, res = 0;
    boolean seen = false;

    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0 && seen) {
        while (nums[left] != 0) {
          left++;
        }
        seen = false;
        left++;
      }

      if (nums[right] == 0 && !seen) {
        seen = true;
      }

      res = Math.max(res, right - left + 1);
    }

    return res - 1;
  }
}
