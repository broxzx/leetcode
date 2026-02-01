package com.fyuizee.p155;

import java.util.Stack;

/**
 * Solution
 */
public class Solution {

  class MinStack {

    private Stack<Integer> min;
    private Stack<Integer> origin;

    public MinStack() {
      this.min = new Stack<>();
      this.origin = new Stack<>();
    }

    public void push(int val) {
      if (min.isEmpty() || min.peek() >= val) {
        min.push(val);
      }
      origin.push(val);
    }

    public void pop() {
      if (origin.peek().equals(min.peek())) {
        min.pop();
      }

      origin.pop();
    }

    public int top() {
      return origin.peek();
    }

    public int getMin() {
      return min.peek();
    }
  }
}
