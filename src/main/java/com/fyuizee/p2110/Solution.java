package com.fyuizee.p2110;

public class Solution {

  public static void main(String[] args) {
    System.out.println(getDescentPeriods(new int[]{3, 2, 1, 3, 2, 1}));
  }

  public static long getDescentPeriods(int[] prices) {
    int left = 0;
    long res = 0;

    for (int right = 0; right < prices.length; right++) {
      if (prices[left] - prices[right] == right - left) {
        res += right - left + 1;
      } else {
        res++;
        left = right;
      }
    }

    return res;
  }
}
