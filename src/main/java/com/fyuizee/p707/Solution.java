package com.fyuizee.p707;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.addAtHead(4); // 4
    System.out.println(myLinkedList.get(1));
    myLinkedList.addAtHead(1); // 1 -> 4
    myLinkedList.addAtHead(5); // 5 -> 1 -> 4
    myLinkedList.deleteAtIndex(3);
    myLinkedList.addAtHead(7);
    System.out.println(myLinkedList.get(3));
    System.out.println(myLinkedList.get(3));
    System.out.println(myLinkedList.get(3));
    myLinkedList.addAtHead(1);
    myLinkedList.deleteAtIndex(4);
  }

  static class MyLinkedList {

    int size;
    Node head;

    public MyLinkedList() {
      this.head = new Node(-1);
      this.size = 0;
    }

    public int get(int index) {
      Node node = getNode(index);

      return node != null ? node.val : -1;
    }

    private Node getNode(int index) {
      if (index < 0 || index > size) {
        return null;
      }

      int i = -1;
      Node current = head;

      while (i++ != index) {
        current = current.next;
      }

      return current;
    }

    public void addAtHead(int val) {
      Node newNode = new Node(val);

      newNode.next = head.next;
      head.next = newNode;
      size++;
    }

    public void addAtTail(int val) {
      Node lastNode = getNode(size - 1);
      Node newNode = new Node(val);

      if (lastNode == null) {
        addAtHead(val);
      } else {
        lastNode.next = newNode;
        size++;
      }
    }

    public void addAtIndex(int index, int val) {
      if (index < 0 || index > size) {
        return;
      }

      if (index == 0) {
        addAtHead(val);
      } else {
        Node prevNode = getNode(index - 1);
        Node newNode = new Node(val);

        newNode.next = prevNode.next;
        prevNode.next = newNode;
        size++;
      }
    }

    public void deleteAtIndex(int index) {
      if (index < 0 || index >= size) {
        return;
      }

      if (index == 0) {
        head.next = head.next.next;
      } else {
        Node node = getNode(index - 1);
        node.next = node.next.next;
      }

      size--;
    }
  }

  static class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }

    public Node() {
    }

  }
}
