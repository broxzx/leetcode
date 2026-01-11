package com.fyuizee.p904;

public class Solution {

  public static void main(String[] args) {
    System.out.println(totalFruit(new int[]{0,0,1,1}));
  }

  public static int totalFruit(int[] nums) {
    int left = 0, res = 0;

    int first = -1, second = -1;
    for (int right = 0; right < nums.length; right++) {
      if (first == -1) {
        first = nums[right];
      } else if (nums[right] != first && second == -1) {
        second = nums[right];
      }

      if (second != -1 && nums[right] != first && nums[right] != second) {
        left = right - 1;
        int prev = nums[left];

        while (left -1 > 0 && nums[left - 1] == prev) {
          left--;
        }
        first = nums[left];
        second = nums[right];
      }

      res = Math.max(res, right - left + 1);
    }

    return res;
  }
}
