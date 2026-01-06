package com.fyuizee.p1161;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public static void main(String[] args) {
    TreeNode tree = buildTree(new Integer[] { 1, 7, 0, 7, -8, null, null });

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
    int maxLevel = 0;
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

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static TreeNode buildTree(Integer[] values) {
    if (values == null || values.length == 0 || values[0] == null) {
      return null;
    }

    TreeNode root = new TreeNode(values[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;

    while (i < values.length) {
      TreeNode current = queue.poll();

      // left child
      if (i < values.length && values[i] != null) {
        current.left = new TreeNode(values[i]);
        queue.offer(current.left);
      }
      i++;

      // right child
      if (i < values.length && values[i] != null) {
        current.right = new TreeNode(values[i]);
        queue.offer(current.right);
      }
      i++;
    }

    return root;
  }
}
