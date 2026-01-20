package com.fyuizee.p83;

import com.fyuizee.utils.ListNode;

public class Solution {

  public static void main(String[] args) {

  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head;

    while (cur != null) {
      while (cur.next != null && cur.val == cur.next.val) {
        cur.next = cur.next.next;
      }

      cur = cur.next;
    }

    return head;
  }
}
