package com.fyuizee.p143;

import com.fyuizee.utils.ListNode;
import com.fyuizee.utils.ListNodeUtil;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    ListNode test = ListNodeUtil.buildList(new int[] { 1, 2, 3, 4 });
    reorderList(test);
    System.out.println(test);

    ListNode test2 = ListNodeUtil.buildList(new int[] { 1, 2, 3, 4, 5 });
    reorderList(test2);
    System.out.println(test2);
  }

  public static void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode slow = head, fast = head, prev = null;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;
    }

    prev.next = null;
    ListNode tail = reverseNode(slow);

    ListNode currentHead = head, temp = head;
    while (currentHead != null && tail != null) {
      ListNode next = tail;
      tail = tail.next;

      next.next = currentHead.next;
      currentHead.next = next;
      temp = currentHead.next;
      currentHead = currentHead.next.next;
    }

    if (tail != null) {
      temp.next = tail;
    }
  }

  private static ListNode reverseNode(ListNode node) {
    ListNode prev = null, current = node;

    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }
}
