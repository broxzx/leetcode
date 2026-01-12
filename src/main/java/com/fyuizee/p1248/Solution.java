package com.fyuizee.p1248;

public class Solution {

  public static void main(String[] args) {

    System.out.println(numberOfSubarrays(new int[]{4, 4, 4, 4, 4, 4, 4, 4}, 2));
  }

  public static int numberOfSubarrays(int[] nums, int k) {
    return atMost(nums, k) - atMost(nums, k - 1);
  }

  private static int atMost(int[] nums, int k) {
    int left = 0, res = 0, odd = 0;

    for (int right = 0; right < nums.length; right++) {
      if (nums[right] % 2 == 1) odd++;

      while (odd > k) {
        if (nums[left++] % 2 == 1) odd--;
      }
      res += right - left + 1;
    }

    return res;
  }

}
