package com.fyuizee.p515;

import com.fyuizee.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public List<Integer> largestValues(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();

        max = Math.max(max, node.val);

        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }

      res.add(max);
    }

    return res;
  }
}
