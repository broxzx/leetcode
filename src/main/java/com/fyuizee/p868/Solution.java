package com.fyuizee.p868;

public class Solution {

  public int binaryGap(int n) {
    String str = Integer.toBinaryString(n);

    int len = str.length();
    int res = 0;
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == '1') {
        for (int j = i + 1; j < len; j++) {
          if (str.charAt(j) == '1') {
            res = Math.max(res, j - i);
            break;
          }
        }
      }
    }

    return res;
  }
}
