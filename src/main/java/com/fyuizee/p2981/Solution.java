package com.fyuizee.p2981;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
    System.out.println(maximumLength("abcdabcddddabcddddccccbbbbaaaa"));
  }

  public static int maximumLength(String s) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      StringBuilder stringBuilder = new StringBuilder();
      for (int j = i; j < s.length(); j++) {
        if (!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length() - 1) != s.charAt(j)) {
          break;
        }
        stringBuilder.append(s.charAt(j));
        map.put(stringBuilder.toString(), map.getOrDefault(stringBuilder.toString(), 0) + 1);
      }
    }

    return map
      .entrySet()
      .stream()
      .filter(stringIntegerEntry -> stringIntegerEntry.getValue() >= 3)
      .map(Map.Entry::getKey)
      .map(String::length)
      .max(Comparator.comparingInt(o -> o)).orElse(-1);
  }

}
