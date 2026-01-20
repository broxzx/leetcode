package com.fyuizee.utils;

public class ListNode {

  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(this.val + " -> ");

    while (next != null) {
      stringBuilder.append(next.val + " -> ");
      next = next.next;
    }

    return stringBuilder.toString();
  }

}
