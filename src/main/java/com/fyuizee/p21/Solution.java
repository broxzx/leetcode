package com.fyuizee.p21;

import com.fyuizee.utils.ListNode;
import com.fyuizee.utils.ListNodeUtil;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(
        mergeTwoLists(ListNodeUtil.buildList(new int[] { 1, 2, 4 }), ListNodeUtil.buildList(new int[] { 1, 3, 4 })));
  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val > list2.val) {
        current.next = list2;
        list2 = list2.next;
      } else {
        current.next = list1;
        list1 = list1.next;
      }

      current = current.next;
    }

    if (list2 != null) {
      current.next = list2;
    }

    if (list1 != null) {
      current.next = list1;
    }

    return dummy.next;
  }
}
