package com.fyuizee.p1475;

public class Solution {

  public static void main(String[] args) {

  }

  public int[] finalPrices(int[] prices) {
    int[] res = new int[prices.length];

    for (int i = 0; i < prices.length; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = i + 1; j < prices.length; j++) {
        if (prices[j] <= prices[i]) {
          min = prices[j];
          break;
        }

      }
      if (min != Integer.MAX_VALUE) {
        res[i] = prices[i] - min;
      } else {
        res[i] = prices[i];
      }
    }

    return res;
  }


}
