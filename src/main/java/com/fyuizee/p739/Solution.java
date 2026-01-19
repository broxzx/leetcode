package com.fyuizee.p739;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
  }

  public static int[] dailyTemperatures(int[] temperature) {
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[temperature.length];

    for (int i = 0; i < temperature.length; i++) {
      while (!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
        Integer pop = stack.pop();
        res[pop] = i - pop;
      }

      stack.push(i);
    }

    return res;
  }

}
