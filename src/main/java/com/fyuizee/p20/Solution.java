package com.fyuizee.p20;

import java.util.Set;
import java.util.Stack;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {

  }

  public boolean isValid(String s) {
    Stack<Character> chars = new Stack<>();
    Set<Character> openings = Set.of('(', '{', '[');

    for (char c : s.toCharArray()) {
      if (openings.contains(c)) {
        chars.push(c);
      } else {
        if (chars.isEmpty()) {
          return false;
        }
        Character peek = chars.peek();
        if (c == ')' && peek == '(' || c == '}' && peek == '{' || c == ']' && peek == '[') {
          chars.pop();
        } else {
          return false;
        }
      }
    }

    return chars.isEmpty();
  }
}
