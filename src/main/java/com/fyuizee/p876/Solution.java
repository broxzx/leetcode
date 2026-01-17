package com.fyuizee.p876;

import com.fyuizee.utils.ListNode;

public class Solution {

  public static void main(String[] args) {

  }

  public ListNode middleNode(ListNode head) {
    ListNode nextNext = head;

    if (nextNext == null) {
      return head;
    }

    while (nextNext != null && nextNext.next != null) {
      head = head.next;
      nextNext = nextNext.next.next;
    }

    return head;
  }
}
