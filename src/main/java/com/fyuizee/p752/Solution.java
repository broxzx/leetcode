package com.fyuizee.p752;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    System.out.println(solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
//  }
//
//  public int openLock(String[] deadends, String target) {
//    int count = 0;
//    Queue<StringBuilder> queue = new LinkedList<>();
//    queue.add(new StringBuilder("0000"));
//
//    Set<String> not = Arrays.stream(deadends).collect(Collectors.toSet());
//    Set<StringBuilder> seen = new HashSet<>();
//    while (!queue.isEmpty()) {
//      StringBuilder cur = queue.remove();
//
//      for (int i = 0; i < 4; i++) {
//        int index = cur.length() - 1 - i;
//        int val = cur.charAt(index) - '0';
//        StringBuilder increase = new StringBuilder(cur);
//        increase.setCharAt(index, (char) (((val + 1) % 10) + '0'));
//        if (increase.toString().equals(target)) {
//          return count;
//        }
//        if (!not.contains(increase.toString()) && !seen.contains(increase)) {
//          seen.add(increase);
//          queue.add(increase);
//        }
//      }
//      count++;
//    }
//
//
//    return -1;
//  }

}
