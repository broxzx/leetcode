package com.fyuizee.p1161;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.fyuizee.utils.TreeNode;
import com.fyuizee.utils.TreeNodeUtil;

public class Solution {

  public static void main(String[] args) {
    TreeNode tree = TreeNodeUtil.buildTree(new Integer[] { 1, 7, 0, 7, -8, null, null });

    System.out.println(maxLevelSum(tree));
  }

  public static int maxLevelSum(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();

    if (root.left != null) {
      queue.add(root.left);
    }
    if (root.right != null) {
      queue.add(root.right);
    }

    int res = root.val;
    int maxLevel = 1;
    int level = 1;
    while (!queue.isEmpty()) {
      int sum = 0;
      level++;

      List<TreeNode> anotherQueue = new LinkedList<>();
      while (!queue.isEmpty()) {
        TreeNode next = queue.poll();
        anotherQueue.add(next);
      }

      for (TreeNode node : anotherQueue) {
        sum += node.val;
        if (node.right != null) {
          queue.add(node.right);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
      }

      if (sum > res) {
        maxLevel = level;
        res = sum;
      }

    }

    return maxLevel;
  }
}
