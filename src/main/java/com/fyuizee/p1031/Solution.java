package com.fyuizee.p1031;

public class Solution {

  public static void main(String[] args) {
    System.out.println(maxSumTwoNoOverlap(new int[]{8, 20, 6, 2, 20, 17, 6, 3, 20, 8, 12}, 5, 4));
  }

  public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
    return Math.max(maxSum(nums, firstLen, secondLen), maxSum(nums, secondLen, firstLen));
  }

  private static int maxSum(int[] nums, int firstLen, int secondLen) {
    int n = nums.length;

    int[] prefix = new int[n + 1];
    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + nums[i];
    }

    int maxFirst = 0;
    int res = 0;

    for (int i = firstLen; i <= n - secondLen; i++) {
      int firstSum = prefix[i] - prefix[i - firstLen];
      maxFirst = Math.max(maxFirst, firstSum);

      int secondSum = prefix[i + secondLen] - prefix[i];

      res = Math.max(res, maxFirst + secondSum);
    }

    return res;
  }

}
