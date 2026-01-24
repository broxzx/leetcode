package com.fyuizee.utils;

public class ListNodeUtil {

  public static ListNode buildList(int[] arr) {
    if (arr == null || arr.length == 0) {
      return null;
    }

    ListNode head = new ListNode(arr[0]);
    ListNode current = head;

    for (int i = 1; i < arr.length; i++) {
      current.next = new ListNode(arr[i]);
      current = current.next;
    }

    return head;
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
