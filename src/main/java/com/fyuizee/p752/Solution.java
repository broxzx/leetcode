package com.fyuizee.p752;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
  }

  public static int openLock(String[] deadends, String target) {
    int count = 0;
    Queue<StringBuilder> queue = new LinkedList<>();
    queue.add(new StringBuilder("0000"));

    Set<String> not = Arrays.stream(deadends).collect(Collectors.toSet());
    Set<String> seen = new HashSet<>();
    while (!queue.isEmpty()) {
      StringBuilder cur = queue.remove();

      for (int i = 0; i < 4; i++) {
        int index = cur.length() - 1 - i;
        int val = cur.charAt(index) - '0';
        StringBuilder newCur = new StringBuilder(cur);

        if (val + 1 < 10) {
          newCur.setCharAt(index, (char) (val + 1 + '0'));
          System.out.println(newCur);
          if (newCur.toString().equals(target)) {
            return count;
          }

          if (!not.contains(newCur.toString()) && !seen.contains(newCur.toString())) {
            seen.add(newCur.toString());
            queue.add(newCur);
          }
        }
      }
      count++;
    }

    return -1;
  }


}
