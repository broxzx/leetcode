package com.fyuizee.p2390;

import java.util.Stack;

/**
 * Solution
 */
public class Solution {

  public String removeStars(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '*' && !stack.isEmpty()) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    StringBuilder res = new StringBuilder();
    for (char c : stack) {
      res.append(c);
    }

    return res.toString();
  }
}
