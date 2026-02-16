package com.fyuizee.p1325;

import com.fyuizee.utils.TreeNode;
import com.fyuizee.utils.TreeNodeUtil;

public class Solution {

  public static void main(String[] args) {
    System.out.println(removeLeafNodes(TreeNodeUtil.buildTree(new Integer[]{1, 2, 3, 2, null, 2, 4}), 2));
  }

  public static TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null || canDelete(root, target)) {
      return null;
    }

    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);

    return root;
  }

  private static boolean canDelete(TreeNode node, int val) {
    if (node == null) {
      return true;
    }

    return node.val == val && canDelete(node.left, val) && canDelete(node.right, val);
  }
}
