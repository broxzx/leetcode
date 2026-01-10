package com.fyuizee.p448;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]
*/

public class Solution {

  public static void main(String[] args) {
    System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
  }

  public static List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();

    int len = nums.length;
    for (int i = 0; i < len; i++) {
      int val = Math.abs(nums[i]) - 1;

      if (nums[val] > 0) {
        nums[val] = -nums[val];
      }
    }

    for (int i = 0; i < len; i++) {
      if (nums[i] > 0) {
        res.add(i + 1);
      }
    }

    return res;
  }

}
