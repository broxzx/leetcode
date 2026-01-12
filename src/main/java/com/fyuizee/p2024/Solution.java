package com.fyuizee.p2024;

public class Solution {

  public static void main(String[] args) {
    System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
    System.out.println(maxConsecutiveAnswers("TFFT", 1));
    System.out.println(maxConsecutiveAnswers("TTFF", 2));
  }

  public static int maxConsecutiveAnswers(String answerKey, int k) {
    int res = 0, t = 0, f = 0, left = 0;

    for (int right = 0; right < answerKey.length(); right++) {
      if (answerKey.charAt(right) == 'T') {
        t++;
      } else {
        f++;
      }

      if (t <= k || f <= k) {
        res = Math.max(res, t + f);
      } else {
        while (t > k && f > k) {
          char curChar = answerKey.charAt(left++);
          if (curChar == 'T') {
            t--;
          } else {
            f--;
          }
        }
      }
    }

    return res;
  }

}
