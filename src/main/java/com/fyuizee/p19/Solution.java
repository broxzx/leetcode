package com.fyuizee.p19;

import com.fyuizee.utils.ListNode;
import com.fyuizee.utils.ListNodeUtil;

public class Solution {

  public static void main(String[] args) {
    System.out.println(removeNthFromEnd(ListNodeUtil.buildList(new int[] { 1, 2, 3, 4, 5 }), 2));
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode left = dummy, right = dummy;

    while (n-- > 0) {
      right = right.next;
    }

    while (right.next != null) {
      left = left.next;
      right = right.next;
    }

    left.next = left.next.next;
    return dummy.next;
  }
}
