package com.fyuizee.p636;

import java.util.List;
import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
    System.out.println(exclusiveTime(2, List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6")));
  }

  public static int[] exclusiveTime(int n, List<String> logs) {
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<>();
    int prevTime = 0;

    for (String log : logs) {
      String[] parts = log.split(":");
      int id = Integer.parseInt(parts[0]);
      String type = parts[1];
      int time = Integer.parseInt(parts[2]);

      if (type.equals("start")) {
        if (!stack.isEmpty()) {
          res[stack.peek()] += time - prevTime;
        }
        stack.push(id);
        prevTime = time;
      } else {
        res[stack.pop()] += time - prevTime + 1;
        prevTime = time + 1;
      }
    }

    return res;
  }
}
