package com.fyuizee.p234;

import com.fyuizee.utils.ListNode;
import com.fyuizee.utils.ListNodeUtil;

public class Solution {

  public static void main(String[] args) {
    System.out.println(isPalindrome(ListNodeUtil.buildList(new int[] { 1, 1, 2, 1 })));
  }

  public static boolean isPalindrome(ListNode head) {
    ListNode reversed = reverse(head);

    while (head != null) {
      if (head.val != reversed.val) {
        return false;
      }

      head = head.next;
      reversed = reversed.next;
    }

    return true;
  }

  public static ListNode reverse(ListNode node) {
    ListNode prev = null, current = copy(node);

    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  public static ListNode copy(ListNode node) {
    ListNode newNode = new ListNode(0), dummy = newNode;

    while (node != null) {
      dummy.next = new ListNode(node.val);
      dummy = dummy.next;
      node = node.next;
    }

    return newNode.next;
  }
}
