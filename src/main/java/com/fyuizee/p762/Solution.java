package com.fyuizee.p762;

import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.countPrimeSetBits(6, 10));
  }

  public int countPrimeSetBits(int left, int right) {
    boolean[] primes = new boolean[right + 1];
    Arrays.fill(primes, true);
    primes[0] = false;
    primes[1] = false;

    for (int i = 2; i * i <= right; i++) {
      if (primes[i]) {
        for (int j = i * i; j <= right; j += i) {
          primes[j] = false;
        }
      }
    }

    int res = 0;
    for (int i = left; i <= right; i++) {
      int count = Integer.bitCount(i);

      if (primes[count]) {
        res++;
      }
    }


    return res;
  }

}
