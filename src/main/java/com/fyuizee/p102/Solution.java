package com.fyuizee.p102;

import com.fyuizee.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> cur = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        cur.add(node.val);

        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }

      res.add(cur);
    }

    return res;
  }
}
