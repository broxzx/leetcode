package com.fyuizee.p3315;

import java.util.Arrays;
import java.util.List;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(minBitwiseArray(List.of(2, 3, 5, 7))));
  }

  public static int[] minBitwiseArray(List<Integer> nums) {
    int n = nums.size();
    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      int x = nums.get(i);
      int res = -1;
      int d = 1;
      while ((x & d) != 0) {
        res = x - d;
        d <<= 1;
      }
      result[i] = res;
    }
    return result;
  }

}
