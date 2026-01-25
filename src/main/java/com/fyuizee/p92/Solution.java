package com.fyuizee.p92;

import com.fyuizee.utils.ListNode;
import com.fyuizee.utils.ListNodeUtil;

public class Solution {

  public static void main(String[] args) {
    System.out.println(reverseBetween(ListNodeUtil.buildList(new int[] { 1, 2, 3, 4, 5 }), 1, 4));
  }

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    left -= 1;
    right -= 1;

    int curPos = 0;
    ListNode prev = null, dummy = new ListNode(0, head);

    while (head != null) {
      if (curPos >= left && curPos <= right) {
        if (prev == null) {
          return reverseTo(head, prev, curPos, right);
        } else {
          prev.next = reverseTo(head, prev, curPos, right);
        }
        break;
      } else {
        prev = head;
        head = head.next;
      }

      curPos++;
    }

    return dummy.next;
  }

  private static ListNode reverseTo(ListNode node, ListNode prev, int curPos, int right) {
    ListNode current = node;
    ListNode sublistHead = node;

    while (curPos <= right) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      curPos++;
    }

    sublistHead.next = current;

    return prev;
  }
}
