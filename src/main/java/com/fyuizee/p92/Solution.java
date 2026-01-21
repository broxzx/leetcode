package com.fyuizee.p92;

import com.fyuizee.utils.ListNode;

public class Solution {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    int curPos = 0;
    ListNode prev = null, cur = head;

    while (curPos < left) {
      prev = cur;
      cur = cur.next;
    }

    while (curPos <= right) {
    }
  }

}
