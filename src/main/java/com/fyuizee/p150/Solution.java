package com.fyuizee.p150;

import java.util.Stack;

public class Solution {

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String s : tokens) {
      char currentChar = s.charAt(0);
      if (isArithmeticExpression(s)) {
        int second = stack.pop();
        int first = stack.pop();

        if (currentChar == '+') {
          stack.push(first + second);
        } else if (currentChar == '-') {
          stack.push(first - second);
        } else if (currentChar == '*') {
          stack.push(first * second);
        } else if (currentChar == '/') {
          stack.push(first / second);
        }
      } else {
        stack.push(Integer.parseInt(s));
      }
    }

    return stack.pop();
  }

  public boolean isArithmeticExpression(String s) {
    return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
  }
}
