package com.fyuizee.p141;

import java.util.HashSet;
import java.util.Set;

import com.fyuizee.utils.ListNode;
import com.fyuizee.utils.ListNodeUtil;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(hasCycle(ListNodeUtil.buildList(new int[] { 3, 2, 0, -4 })));
  }

  // Soltuon #1
  // public boolean hasCycle(ListNode head) {
  // Set<ListNode> nodes = new HashSet<>();
  //
  // while (head != null) {
  // nodes.add(head);
  // if (head.next != null && nodes.contains(head.next)) {
  // return true;
  // }
  //
  // head = head.next;
  // }
  //
  // return false;
  // }

  // Floid's algorithm
  public static boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true;
      }
    }

    return false;
  }

}
