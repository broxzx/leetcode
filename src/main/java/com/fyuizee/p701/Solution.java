package com.fyuizee.p701;

import com.fyuizee.utils.TreeNode;

public class Solution {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (val > root.val) {
      root.right = insertIntoBST(root.right, val);
    } else {
      root.left = insertIntoBST(root.left, val);
    }
    return root;
  }
}
