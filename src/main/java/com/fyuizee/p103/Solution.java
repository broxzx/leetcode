package com.fyuizee.p103;

import com.fyuizee.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

  // solution with a list
//  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//    if (root == null) {
//      return new ArrayList<>();
//    }
//
//    Queue<TreeNode> q = new LinkedList<>();
//    q.add(root);
//
//    List<List<Integer>> res = new ArrayList<>();
//    boolean fromLeft = true;
//    while (!q.isEmpty()) {
//      int size = q.size();
//
//      List<Integer> nodes = new ArrayList<>();
//      for (int i = 0; i < size; i++) {
//        TreeNode node = q.remove();
//
//        if (node.left != null) {
//          q.add(node.left);
//        }
//
//        if (node.right != null) {
//          q.add(node.right);
//        }
//        nodes.add(node.val);
//      }
//
//      if (fromLeft) {
//        res.add(nodes);
//        fromLeft = false;
//      } else {
//        res.add(nodes.reversed());
//        fromLeft = true;
//      }
//    }
//
//    return res;
//  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Deque<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    boolean reversed = false;
    List<List<Integer>> res = new ArrayList<>();
    while (!q.isEmpty()) {
      int size = q.size();

      List<Integer> nodes = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node;
        if (!reversed) {
          node = q.removeFirst();

          if (node.left != null) {
            q.addLast(node.left);
          }
          if (node.right != null) {
            q.addLast(node.right);
          }
        } else {
          node = q.removeLast();

          if (node.right != null) {
            q.addFirst(node.right);
          }
          if (node.left != null) {
            q.addFirst(node.left);
          }
        }
        nodes.add(node.val);

      }

      res.add(nodes);
      reversed = !reversed;
    }

    return res;
  }

}
