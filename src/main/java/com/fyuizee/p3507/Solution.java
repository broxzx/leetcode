package com.fyuizee.p3507;

/**
 * Solution
 */
public class Solution {
  public int minimumPairRemoval(int[] nums) {
    int count = 0;

    while (!isNonDecreasing(nums)) {
      int length = nums.length;
      int min = Integer.MAX_VALUE;
      int index = 0;
      int[] newArray = new int[nums.length - 1];

      for (int i = 0; i < length - 1; i++) {
        if (min > nums[i] + nums[i + 1]) {
          min = nums[i] + nums[i + 1];
          index = i;
        }
      }

      int pointer = 0;
      for (int i = 0; i < length; i++) {
        if (i == index) {
          newArray[pointer] = min;
          i += 1;
        } else {
          newArray[pointer] = nums[i];
        }

        pointer++;
      }

      nums = newArray;
      count++;
    }

    return count;
  }

  private boolean isNonDecreasing(int[] nums) {
    int length = nums.length;
    for (int i = 0; i < length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        return false;
      }
    }

    return true;
  }
}
