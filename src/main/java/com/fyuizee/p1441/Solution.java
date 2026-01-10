package com.fyuizee.p1441;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    System.out.println(buildArray(new int[] { 1, 2 }, 4));
  }

  public static List<String> buildArray(int[] target, int n) {
    List<String> res = new ArrayList<>();
    int pointer = 0;
    for (int i = 1; i <= n && pointer < target.length; i++) {
      res.add("Push");

      if (i == target[pointer]) {
        pointer++;
      } else {
        res.add("Pop");
      }
    }

    return res;
  }
}
