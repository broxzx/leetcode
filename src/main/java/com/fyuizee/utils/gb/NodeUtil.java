package com.fyuizee.utils.gb;

import java.util.LinkedList;
import java.util.Queue;

public class NodeUtil {

  public static Node buildTree(Integer[] arr) {
    if (arr == null || arr.length == 0 || arr[0] == null) {
      return null;
    }

    Node root = new Node(arr[0]);
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;

    while (!queue.isEmpty() && i < arr.length) {
      Node current = queue.poll();

      // Left child
      if (i < arr.length && arr[i] != null) {
        current.left = new Node(arr[i]);
        queue.offer(current.left);
      }
      i++;

      // Right child
      if (i < arr.length && arr[i] != null) {
        current.right = new Node(arr[i]);
        queue.offer(current.right);
      }
      i++;
    }

    return root;
  }

}
