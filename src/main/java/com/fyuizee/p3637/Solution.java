package com.fyuizee.p3637;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {

  }

  public boolean isTrionic(int[] nums) {
    int firstPoint = 1, len = nums.length;
    while (firstPoint < len && nums[firstPoint] > nums[firstPoint - 1]) {
      firstPoint++;
    }

    int secondPoint = firstPoint - 1;
    while (firstPoint < len && nums[firstPoint] < nums[firstPoint - 1]) {
      firstPoint++;
    }

    int thirdPoint = firstPoint - 1;
    while (firstPoint < len && nums[firstPoint] > nums[firstPoint - 1]) {
      firstPoint++;
    }

    int lastPoint = firstPoint - 1;
    return (secondPoint != 0) && (secondPoint != thirdPoint) && (lastPoint == len - 1 && lastPoint != thirdPoint);
  }
}
