package com.fyuizee.p23;

import com.fyuizee.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public ListNode mergeKLists(ListNode[] lists) {
    Queue<ListNode> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

    for (ListNode node : lists) {
      addAll(node, nodes);
    }

    ListNode head = new ListNode(0);
    ListNode dummy = head;

    while (!nodes.isEmpty()) {
      dummy.next = nodes.remove();
      dummy = dummy.next;
    }

    return head.next;
  }

  private void addAll(ListNode node, Queue<ListNode> nodes) {
    while (node != null) {
      nodes.add(new ListNode(node.val));
      node = node.next;
    }
  }

}
