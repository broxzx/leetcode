package com.fyuizee.p67;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = solution.addBinary("111", "11");
    System.out.println(s);
  }

  public String addBinary(String a, String b) {
    StringBuilder res = new StringBuilder();
    int p1 = a.length() - 1, p2 = b.length() - 1;
    int carry = 0;

    while (p1 >= 0 || p2 >= 0 || carry == 1) {
      int sum = carry;

      if (p1 >= 0) {
        sum += a.charAt(p1--) - '0';
      }
      if (p2 >= 0) {
        sum += b.charAt(p2--) - '0';
      }

      res.append(sum % 2);
      carry = sum / 2;
    }

    return res.reverse().toString();
  }
}
