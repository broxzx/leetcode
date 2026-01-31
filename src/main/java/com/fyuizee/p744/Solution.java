package com.fyuizee.p744;

public class Solution {

  public static void main(String[] args) {
    System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
  }

  public static char nextGreatestLetter(char[] letters, char target) {
    int l = 0, r = letters.length - 1;

    while (l <= r) {
      int m = (l + r) / 2;
      if (letters[m] <= target) l = m + 1;
      else r = m - 1;
    }

    return letters[l % letters.length];
  }

}
