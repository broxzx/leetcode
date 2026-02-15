package com.fyuizee.p3713;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    System.out.println(longestBalanced("zzabccy"));
  }

  public static int longestBalanced(String s) {
    int longest = 0;

    for (int i = 0; i < s.length(); i++) {
      int[] m = new int[26];

      for (int j = i; j < s.length(); j++) {
        m[s.charAt(j) - 'a']++;

        if (isBalanced(m)) {
          longest = Math.max(longest, j - i + 1);
        }

      }
    }

    return longest;
  }

  private static boolean isBalanced(int[] m) {
    Set<Integer> set = new HashSet<>();
    for (int i : m) {
      if (i != 0) {
        set.add(i);
      }
    }
    return set.size() <= 1;
  }

}
