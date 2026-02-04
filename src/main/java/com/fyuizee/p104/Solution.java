package com.fyuizee.p104;

import com.fyuizee.utils.TreeNode;

/**
 * Solution
 */
public class Solution {

  public int maxDepth(TreeNode root) {
    return dfs(root, 0);
  }

  private int dfs(TreeNode node, int level) {
    if (node == null) {
      return level;
    }

    int leftLevel = dfs(node.left, level + 1);
    int rightLevel = dfs(node.right, level + 1);

    return Math.max(leftLevel, rightLevel);
  }
}
