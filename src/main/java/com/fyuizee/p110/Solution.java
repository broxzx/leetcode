package com.fyuizee.p110;

import com.fyuizee.utils.TreeNode;

/**
 * Solution
 */
public class Solution {

  public boolean isBalanced(TreeNode node) {
    if (node == null) {
      return true;
    }

    if (Math.abs(height(node.left, 0) - height(node.right, 0)) > 1) {
      return false;
    }

    return isBalanced(node.left) && isBalanced(node.right);
  }

  private int height(TreeNode node, int level) {
    if (node == null) {
      return level;
    }

    int leftLevel = height(node.left, level + 1);
    int rightLevel = height(node.right, level + 1);

    return Math.max(rightLevel, leftLevel);
  }
}
