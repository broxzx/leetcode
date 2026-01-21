package com.fyuizee.p24;

import com.fyuizee.utils.ListNode;
import com.fyuizee.utils.ListNodeUtil;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(swapPairs(ListNodeUtil.buildList(new int[] { 1, 2, 3, 4 })));
  }

  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0, head);
    ListNode current = dummy;

    while (current.next != null && current.next.next != null) {
      ListNode first = current.next;
      ListNode second = current.next.next;
      current.next = second;
      first.next = second.next;
      second.next = first;
      current = current.next.next;
    }

    return dummy.next;
  }

}
