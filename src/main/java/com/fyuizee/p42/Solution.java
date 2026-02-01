package com.fyuizee.p42;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 2, 2, 1, 2, 1 }));
  }

  public static int trap(int[] height) {
    int leftMax = 0, rightMax = 0;
    int left = 0, right = height.length - 1;
    int res = 0;

    while (left < right) {
      if (height[left] < height[right]) {
        leftMax = Math.max(leftMax, height[left]);
        res += leftMax - height[left++];
      } else {
        rightMax = Math.max(rightMax, height[right]);
        res += rightMax - height[right--];
      }
    }

    return res;
  }
}
