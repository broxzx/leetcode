package com.fyuizee.p143;

import java.util.Stack;

import com.fyuizee.utils.ListNode;
import com.fyuizee.utils.ListNodeUtil;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    ListNode test = ListNodeUtil.buildList(new int[] { 1, 2, 3, 4 });
    reorderList(test);
    System.out.println(test);
  }

  public static void reorderList(ListNode head) {
    ListNode cur = head;
    Stack<ListNode> uneven = new Stack<>();
    int count = 0;

    while (cur != null) {
      if (count % 2 != 0) {
        uneven.add(new ListNode(cur.val));
        count++;
      }
      count++;
      cur = cur.next;
    }

    for (ListNode node : uneven) {
      System.out.println(node);
    }

    cur = head;
    count = 0;
    while (cur != null) {
      if (count++ % 2 == 0 && cur.next != null && !uneven.isEmpty()) {
        ListNode pop = uneven.pop();
        pop.next = cur.next;
        cur.next = pop;
      }

      cur = cur.next;
    }
  }
}
