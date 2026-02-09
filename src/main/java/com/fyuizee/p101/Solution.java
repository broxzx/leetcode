package com.fyuizee.p101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.fyuizee.utils.TreeNode;

/**
 * Solution
 */
public class Solution {

  // iterative
  // public boolean isSymmetric(TreeNode root) {
  // Stack<TreeNode> stack = new Stack<>();
  //
  // stack.add(root.left);
  // stack.add(root.right);
  //
  // while (!stack.isEmpty()) {
  // TreeNode right = stack.pop();
  // TreeNode left = stack.pop();
  //
  // if (right == null && left == null) {
  // continue;
  // }
  //
  // if ((right == null && left != null) || (right != null && left == null)) {
  // return false;
  // }
  //
  // if (right.val != left.val) {
  // return false;
  // }
  //
  // stack.add(right.right);
  // stack.add(left.left);
  // stack.add(right.left);
  // stack.add(left.right);
  // }
  //
  // return true;
  // }
}
