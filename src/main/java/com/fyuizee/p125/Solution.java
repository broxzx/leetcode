package com.fyuizee.p125;

public class Solution {

  public boolean isPalindrome(String s) {
    s = sanitize(s);
    int left = 0, right = s.length() - 1;
    while (left <= right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }

  private String sanitize(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        stringBuilder.append(Character.toLowerCase(c));
      }
    }

    return stringBuilder.toString();
  }

}
