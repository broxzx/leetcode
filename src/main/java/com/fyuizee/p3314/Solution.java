package com.fyuizee.p3314;

import java.util.Arrays;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(minBitwiseArray(List.of(2, 3, 5, 7))));
  }

  public static int[] minBitwiseArray(List<Integer> nums) {
    int[] res = new int[nums.size()];

    Arrays.fill(res, -1);

    for (int i = 0; i < nums.size(); i++) {
      int cur = nums.get(i);
      for (int j = 1; j <= cur; j++) {
        if ((j | (j + 1)) == cur) {
          res[i] = j;
          break;
        }
      }
    }

    return res;
  }
}
