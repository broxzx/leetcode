package com.fyuizee.p2302;

public class Solution {

  public static void main(String[] args) {
    System.out.println(countSubarrays(new int[]{2, 1, 4, 3, 5}, 10));
  }

  public static long countSubarrays(int[] nums, long k) {
    int left = 0;
    long curSum = 0, res = 0;

    for (int right = 0; right < nums.length; right++) {
      curSum += nums[right];

      while (curSum * (right - left + 1) >= k) {
        curSum -= nums[left++];
      }

      res += right - left + 1;
    }

    return res;
  }
}
