package com.fyuizee.p49;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    return Arrays.stream(strs)
      .collect(Collectors.groupingBy(Solution::countChars))
      .values().stream().toList();
  }

  private static String countChars(String str) {
    char[] map = new char[26];

    for (char c : str.toCharArray()) {
      map[c - 'a']++;
    }

    StringBuilder construct = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      if (map[i] != 0) {
        construct.append((char) (i + 26)).append(map[i]).append("->");
      }
    }

    return construct.toString();
  }
}
