package com.fyuizee.utils;

public class ListNode implements Cloneable {

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

    ListNode toIterate = new ListNode(0, next);
    toIterate = toIterate.next;

    while (toIterate != null) {
      String toAppendInner = toIterate.next != null ? toIterate.val + " -> " : toIterate.val + "";
      stringBuilder.append(toAppendInner);
      toIterate = toIterate.next;
    }

    return stringBuilder.toString();
  }

}
