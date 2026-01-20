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
    String toAppend = this.next != null ? this.val + " -> " : this.val + "";
    StringBuilder stringBuilder = new StringBuilder(toAppend);

    while (next != null) {
      String toAppendInner = next.next != null ? next.val + " -> " : next.val + "";
      stringBuilder.append(toAppendInner);
      next = next.next;
    }

    return stringBuilder.toString();
  }

}
