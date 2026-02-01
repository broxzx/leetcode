package com.fyuizee.p15;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> resSet = new HashSet<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1, right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if (sum > 0) {
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          resSet.add(List.of(nums[i], nums[left], nums[right]));
          right--;
          left++;

          while (nums[left] == nums[left-1] && left < right) {
            left++;
          }
        }
      }
    }

    return new ArrayList<>(resSet);
  }

}
