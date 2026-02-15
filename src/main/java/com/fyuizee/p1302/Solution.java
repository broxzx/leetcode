package com.fyuizee.p1302;

import com.fyuizee.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  // bfs
  public int deepestLeavesSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (true) {
      int size = q.size();

      int sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = q.remove();

        sum += node.val;

        if (node.left != null) {
          q.add(node.left);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }

      if (q.isEmpty()) {
        return sum;
      }
    }
  }

}
