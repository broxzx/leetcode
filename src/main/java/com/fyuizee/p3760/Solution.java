package com.fyuizee.p3760;

/*
You are given a string s consisting of lowercase English letters.

Return an integer denoting the maximum number of substrings you can split s into such that each substring starts with a distinct character (i.e., no two substrings start with the same character).

 

Example 1:
Input: s = "abab"
Output: 2

Explanation:
Split "abab" into "a" and "bab".
Each substring starts with a distinct character i.e 'a' and 'b'. Thus, the answer is 2.

Example 2:
Input: s = "abcd"
Output: 4

Explanation:

Split "abcd" into "a", "b", "c", and "d".
Each substring starts with a distinct character. Thus, the answer is 4.

Example 3:
Input: s = "aaaa"
Output: 1

Explanation:
All characters in "aaaa" are 'a'.
Only one substring can start with 'a'. Thus, the answer is 1.

*/

public class Solution {

  public static void main(String[] args) {
    System.out.println(maxDistinct("abab"));
    System.out.println(maxDistinct("abcd"));
    System.out.println(maxDistinct("aaaa"));
  }

  public static int maxDistinct(String s) {
    boolean[] map = new boolean[26];
    int distinct = 0;

    for (char c : s.toCharArray()) {
      if (!map[c - 'a']) {
        distinct++;
      }
      map[c - 'a'] = true;
    }

    return distinct;
  }

}
