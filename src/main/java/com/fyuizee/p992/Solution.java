package com.fyuizee.p992;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
    System.out.println(subarraysWithKDistinct(new int[]{7, 9, 6, 10, 3, 7, 6, 14, 9, 14, 7, 6, 13, 5}, 4));
  }

  public static int subarraysWithKDistinct(int[] nums, int k) {
    return atMostK(nums, k) - atMostK(nums, k - 1);
  }

  private static int atMostK(int[] nums, int k) {
    int left = 0, res = 0;
    Map<Integer, Integer> appear = new HashMap<>();

    for (int right = 0; right < nums.length; right++) {
      appear.put(nums[right], appear.getOrDefault(nums[right], 0) + 1);

      while (appear.size() > k) {
        Integer leftAppear = appear.get(nums[left]);
        int newLeftAppear = leftAppear - 1;
        if (newLeftAppear == 0) {
          appear.remove(nums[left]);
        } else {
          appear.put(nums[left], newLeftAppear);
        }

        left++;
      }

      res += right - left + 1;
    }

    return res;
  }
}
