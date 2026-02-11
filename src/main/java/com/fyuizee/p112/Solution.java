package com.fyuizee.p112;

import com.fyuizee.utils.TreeNode;

/**
 * Solution
 */
public class Solution {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    return res(root, targetSum, 0);
  }

  private boolean res(TreeNode node, int targetSum, int cur) {
    if (node == null) {
      return false;
    }

    cur += node.val;
    if (cur == targetSum && node.left == null && node.right == null) {
      return true;
    }

    return res(node.left, targetSum, cur) || res(node.right, targetSum, cur);
  }
}
