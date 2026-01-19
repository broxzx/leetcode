package com.fyuizee.p1475;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(finalPrices(new int[] { 8, 4, 6, 2, 3 })));
  }

  // Solution number 1 (brute force)
  // public int[] finalPrices(int[] prices) {
  // int[] res = new int[prices.length];
  //
  // for (int i = 0; i < prices.length; i++) {
  // int min = Integer.MAX_VALUE;
  // for (int j = i + 1; j < prices.length; j++) {
  // if (prices[j] <= prices[i]) {
  // min = prices[j];
  // break;
  // }
  //
  // }
  // if (min != Integer.MAX_VALUE) {
  // res[i] = prices[i] - min;
  // } else {
  // res[i] = prices[i];
  // }
  // }
  //
  // return res;
  // }
  //

  // Solution number 2 - monotonic stack. O(n)
  public static int[] finalPrices(int[] prices) {
    Stack<Integer> stack = new Stack<>();
    int[] res = prices.clone();

    for (int i = 0; i < prices.length; i++) {
      while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
        Integer pop = stack.pop();
        res[pop] = prices[pop] - prices[i];
      }

      stack.push(i);
    }

    return res;
  }

}
