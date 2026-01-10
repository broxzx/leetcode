package com.fyuizee.p645;

import java.util.HashSet;
import java.util.Set;

/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]

Example 2:
Input: nums = [1,1]
Output: [1,2]
*/

public class Solution {

  public static void main(String[] args) {

  }

  public int[] findErrorNums(int[] nums) {
    Set<Integer> set = new HashSet<>();

    int duplicated = -1;
    int length = nums.length;
    for (int i : nums) {
      if (!set.add(i)) {
        duplicated = i;
      }
    }

    System.out.println(length);
    for (int i = 1; i <= length; i++) {
      if (!set.contains(i)) {
        return new int[] { duplicated, i };
      }
    }

    return new int[] { -1, -1 };
  }

}
