package com.fyuizee.p1339;

import com.fyuizee.utils.TreeNode;
import com.fyuizee.utils.TreeNodeUtil;

public class Solution {

  public static void main(String[] args) {
    System.out.println(maxProduct(TreeNodeUtil.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6 })));
  }

  private static long res = 0;
  private static long totalSum = 0;
  private static final int mod = 1_000_000_007;

  public static int maxProduct(TreeNode root) {
    totalSum = getSum(root);
    calcMaxProduct(root);

    return (int) (res % mod);
  }

  public static long calcMaxProduct(TreeNode node) {
    if (node == null) {
      return 0;
    }

    long right = calcMaxProduct(node.right);
    long left = calcMaxProduct(node.left);

    long subSum = node.val + right + left;
    long product = subSum * (totalSum - subSum);
    res = Math.max(res, product);

    return subSum;
  }

  public static long getSum(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return node.val + getSum(node.left) + getSum(node.right);
  }

}
