package com.fyuizee.p2537;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
    System.out.println(countGood(new int[]{1, 1, 1, 1, 1}, 10));
  }

  public static long countGood(int[] nums, int k) {
    Map<Integer, Long> freq = new HashMap<>();
    long pairs = 0;
    long res = 0;
    int left = 0;

    for (int right = 0; right < nums.length; right++) {
      long f = freq.getOrDefault(nums[right], 0L);
      pairs += f;
      freq.put(nums[right], f + 1);

      while (pairs >= k) {
        res += nums.length - right;

        long lf = freq.get(nums[left]);
        freq.put(nums[left], lf - 1);
        pairs -= (lf - 1);
        left++;
      }
    }

    return res;
  }
}
