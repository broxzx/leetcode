package com.fyuizee.p206;

import com.fyuizee.utils.ListNode;
import com.fyuizee.utils.ListNodeUtil;

public class Solution {

  public static void main(String[] args) {
    System.out.println(reverseList(ListNodeUtil.buildList(new int[] { 1, 2, 3, 4, 5 })));
  }

  public static ListNode reverseList(ListNode head) {
    ListNode prev = null, dummy = head;

    while (dummy != null) {
      ListNode next = dummy.next;
      dummy.next = prev;
      prev = dummy;
      dummy = next;
    }

    return prev;
  }
}
