package com.fyuizee.p2095;

import com.fyuizee.utils.ListNode;

public class Solution {

  public static void main(String[] args) {

  }

  public ListNode deleteMiddle(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (fast == null) {
        if (slow.next == null) {
          slow.next = null;
        } else {
          slow.next = slow.next.next;
        }
      }
    }

    return head;
  }
}
