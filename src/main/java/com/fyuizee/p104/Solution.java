package com.fyuizee.p104;

import com.fyuizee.utils.TreeNode;
import com.fyuizee.utils.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(maxDepth(TreeNodeUtil.buildTree(new Integer[]{0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8})));
  }

  public static int maxDepth(TreeNode root) {
    return iterative(root);
  }

  private int dfs(TreeNode node, int level) {
    if (node == null) {
      return level;
    }

    int leftLevel = dfs(node.left, level + 1);
    int rightLevel = dfs(node.right, level + 1);

    return Math.max(leftLevel, rightLevel);
  }

  public static int iterative(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    int level = 0;
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        System.out.println("cur: " + cur.val + " level: " + level);

        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }

      level += 1;
    }

    return level;
  }
}
