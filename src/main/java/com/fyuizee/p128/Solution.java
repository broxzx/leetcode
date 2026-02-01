package com.fyuizee.p128;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {

  }

  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }

    int res = 0;
    for (int num : nums) {
      if (set.contains(num - 1)) {
        continue;
      }

      int count = 1;
      int cur = num;
      while (set.contains(++cur)) {
        count++;
      }

      res = Math.max(res, count);
    }

    return res;
  }

}
