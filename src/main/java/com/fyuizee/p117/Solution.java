package com.fyuizee.p117;

import com.fyuizee.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();
      Node prev = null;

      for (int i = 0; i < size; i++) {
        Node curr = q.remove();

        if (prev != null) {
          prev.next = curr;
        }
        prev = curr;

        if (curr.left != null) {
          q.add(curr.left);
        }
        if (curr.right != null) {
          q.add(curr.right);
        }
      }
      prev.next = null;
    }
    return root;
  }
}
