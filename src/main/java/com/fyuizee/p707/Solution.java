package com.fyuizee.p707;

import com.fyuizee.p707.Solution.Node;

import com.fyuizee.p707.Solution.Node;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.addAtHead(1);
    myLinkedList.addAtTail(3);
    myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
    myLinkedList.get(1); // return 2
    myLinkedList.deleteAtIndex(1); // now the linked list is 1->3
    myLinkedList.get(1);
  }

  static class MyLinkedList {

    private Node dummy;
    private int size;

    public MyLinkedList() {
      this.dummy = new Node();
      this.size = 0;
    }

    public int get(int index) {
      return getNode(index).val;
    }

    public Node getNode(int index) {
      if (index > size) {
        return new Node(-1);
      }

      int i = -1;
      Node current = dummy;
      while (i++ != size) {
        current = current.next;
      }

      return current;
    }

    public void addAtHead(int val) {
      addToNode(new Node(val), dummy);
      size++;
    }

    public void addAtTail(int val) {
      Node tailNode = dummy;

      while (tailNode.next != null) {
        tailNode = tailNode.next;
      }

      addToNode(new Node(val), tailNode);
      size++;
    }

    private void addToNode(Node newNode, Node oldNode) {
      Node next = oldNode.next;
      if (next != null) {
        newNode.next = next;
        newNode.prev = next.prev;
        next.prev = newNode;
      } else {
        newNode.prev = dummy;
      }

      oldNode.next = newNode;
    }

    public void addAtIndex(int index, int val) {
      Node node = getNode(index);
      addToNode(new Node(val), node);
    }

    public void deleteAtIndex(int index) {
      Node node = getNode(index);

      node.prev = node.next;
    }
  }

  static class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val, Node next, Node prev) {
      this.val = val;
      this.next = next;
      this.prev = prev;
    }

    public Node() {
    }

    public Node(int val) {
      this.val = val;
    }
  }
}
