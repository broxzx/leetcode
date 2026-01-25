package com.fyuizee.p725;

import java.util.Arrays;

import com.fyuizee.utils.ListNode;
import com.fyuizee.utils.ListNodeUtil;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(splitListToParts(ListNodeUtil.buildList(new int[] { 1, 2, 3 }), 5)));
  }

  public static ListNode[] splitListToParts(ListNode head, int k) {
    int length = 0;
    ListNode[] res = new ListNode[k];
    ListNode current = head;

    while (current != null) {
      length++;
      current = current.next;
    }

    for (int i = 0; i < res.length; i++) {
      res[i] = new ListNode(0);
    }

    int bucketSize = length / k; // how many nodes each bucket should have (at least)
    int currentBucket = 0;
    int leftover = length % k;
    while (currentBucket < k || currentBucket < leftover) {
      ListNode cur = res[currentBucket];

      for (int i = 0; i < bucketSize; i++) {
        cur.next = new ListNode(head.val);
        cur = cur.next;
        head = head.next;

      }

      if (currentBucket < leftover) {
        cur.next = new ListNode(head.val);
        cur = cur.next;
        head = head.next;
      }

      currentBucket++;
    }

    for (int i = 0; i < res.length; i++) {
      res[i] = res[i].next;
    }

    return res;
  }

}
