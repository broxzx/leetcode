package com.fyuizee.p225;

import java.util.Stack;

import com.fyuizee.utils.TreeNode;

/**
 * Solution
 */
public class Solution {

  // recursive
  // public TreeNode invertTree(TreeNode root) {
  // if (root == null) {
  // return root;
  // }
  //
  // TreeNode left = root.left;
  // root.left = root.right;
  // root.right = left;
  //
  // invertTree(root.left);
  // invertTree(root.right);
  //
  // return root;
  // }

  // iterative
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      TreeNode left = node.left;
      node.left = node.right;
      node.right = left;

      if (node.left != null) {
        stack.add(node.left);
      }

      if (node.right != null) {
        stack.add(node.right);
      }
    }

    return root;
  }

}
