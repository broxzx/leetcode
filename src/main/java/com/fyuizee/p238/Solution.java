package com.fyuizee.p238;

public class Solution {

  public static void main(String[] args) {
    System.out.println(productExceptSelf(new int[] {1,2,3,4}));
  }

  public static int[] productExceptSelf(int[] nums) {
    int[] prefix = new int[nums.length];
    int[] suffix = new int[nums.length];

    int prefixProduct = 1;
    for (int i = 0; i < nums.length; i++) {
      prefixProduct *= nums[i];
      prefix[i] = prefixProduct;
    }

    int suffixProduct = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      suffixProduct *= nums[i];
      suffix[i] = suffixProduct;
    }

    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int sum = 1;
      if (i > 0) {
        sum *= prefix[i - 1];
      }
      if (i + 1 < nums.length) {
        sum *= suffix[i + 1];
      }

      res[i] = sum;
    }

    return res;
  }

}
