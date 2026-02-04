package com.fyuizee.p707;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();

    myLinkedList.addAtHead(84);
    myLinkedList.addAtTail(2);
    myLinkedList.addAtTail(39);
    System.out.println(myLinkedList.get(3));
    System.out.println(myLinkedList.get(1));
    myLinkedList.addAtTail(42);
    myLinkedList.addAtIndex(1, 80);
    myLinkedList.addAtHead(14);
    myLinkedList.addAtHead(1);
    myLinkedList.addAtTail(53);
    myLinkedList.addAtTail(98);
    myLinkedList.addAtTail(19);
    myLinkedList.addAtTail(12);
    System.out.println(myLinkedList.get(2));
    myLinkedList.addAtHead(16);
    myLinkedList.addAtHead(33);
    myLinkedList.addAtIndex(4, 17);
    myLinkedList.addAtIndex(6, 8);
    myLinkedList.addAtHead(37);
    myLinkedList.addAtTail(43);
    myLinkedList.deleteAtIndex(11);
    myLinkedList.addAtHead(80);
    myLinkedList.addAtHead(31);
    myLinkedList.addAtIndex(13, 23);
    myLinkedList.addAtTail(17);
    System.out.println(myLinkedList.get(4));
    myLinkedList.addAtIndex(10, 0);
    myLinkedList.addAtTail(21);
    myLinkedList.addAtHead(73);
    myLinkedList.addAtHead(22);
    myLinkedList.addAtIndex(24, 37);
    myLinkedList.addAtTail(14);
    myLinkedList.addAtHead(97);
    myLinkedList.addAtHead(8);
    System.out.println(myLinkedList.get(6));
    myLinkedList.deleteAtIndex(17);
    myLinkedList.addAtTail(50);
    myLinkedList.addAtTail(28);
    myLinkedList.addAtHead(76);
    myLinkedList.addAtTail(79);
    System.out.println(myLinkedList.get(18));
    myLinkedList.deleteAtIndex(30);
    myLinkedList.addAtTail(5);
    myLinkedList.addAtHead(9);
    myLinkedList.addAtTail(83);
    myLinkedList.deleteAtIndex(3);
    myLinkedList.addAtTail(40);
    myLinkedList.deleteAtIndex(26);
    myLinkedList.addAtIndex(20, 90);
    myLinkedList.deleteAtIndex(30);
    myLinkedList.addAtTail(40);
    myLinkedList.addAtHead(56);
    myLinkedList.addAtIndex(15, 23);
    myLinkedList.addAtHead(51);
    myLinkedList.addAtHead(21);
    System.out.println(myLinkedList.get(26));
    myLinkedList.addAtHead(83);
    System.out.println(myLinkedList.get(30));
    myLinkedList.addAtHead(12);
    myLinkedList.deleteAtIndex(8);
    System.out.println(myLinkedList.get(4));
    myLinkedList.addAtHead(20);
    myLinkedList.addAtTail(45);
    System.out.println(myLinkedList.get(10));
    myLinkedList.addAtHead(56);
    System.out.println(myLinkedList.get(18));
    myLinkedList.addAtTail(33);
    System.out.println(myLinkedList.get(2));
    myLinkedList.addAtTail(70);
    myLinkedList.addAtHead(57);
    myLinkedList.addAtIndex(31, 24);
    myLinkedList.addAtIndex(16, 92);
    System.out.println(myLinkedList.get(40));
    myLinkedList.addAtHead(23);
    myLinkedList.addAtIndex(26, 1);
    myLinkedList.addAtHead(92);
    myLinkedList.addAtIndex(3, 78);
    myLinkedList.addAtTail(42);
    System.out.println(myLinkedList.get(18));
    myLinkedList.addAtIndex(39, 9);
    myLinkedList.addAtTail(13);
    myLinkedList.addAtIndex(33, 17);
    myLinkedList.addAtTail(51);
    myLinkedList.addAtIndex(18, 95);
    myLinkedList.addAtIndex(18, 33);
    myLinkedList.addAtHead(80);
    myLinkedList.addAtHead(21);
    myLinkedList.addAtTail(7);
    myLinkedList.addAtIndex(17, 46);
    myLinkedList.addAtTail(33);
    myLinkedList.addAtTail(60);
    myLinkedList.addAtHead(26);
    System.out.println(myLinkedList.get(4));
    myLinkedList.addAtHead(9);
    myLinkedList.addAtIndex(45, 38);
    myLinkedList.addAtTail(95);
    myLinkedList.addAtTail(78);
    myLinkedList.addAtHead(54);
    myLinkedList.addAtIndex(42, 86);
  }

  static class MyLinkedList {

    private final Node dummy;
    private int size;

    public MyLinkedList() {
      this.dummy = new Node();
      this.size = 0;
    }

    public int get(int index) {
      Node node = getNode(index);
      return node != null ? node.val : -1;
    }

    public Node getNode(int index) {
      if (index > size || index < 0) {
        return null;
      }

      int i = -1;
      Node current = dummy;
      while (i++ != index) {
        current = current.next;
      }

      return current;
    }

    public void addAtHead(int val) {
      addToNode(new Node(val), dummy);
    }

    public void addAtTail(int val) {
      Node tailNode = dummy;

      while (tailNode.next != null) {
        tailNode = tailNode.next;
      }

      addToNode(new Node(val), tailNode);
    }

    private void addToNode(Node newNode, Node oldNode) {
      Node next = oldNode.next;
      if (next != null) {
        newNode.next = next;
        newNode.prev = oldNode;
        next.prev = newNode;
      } else {
        newNode.prev = dummy;
      }

      oldNode.next = newNode;
      size++;
    }

    public void addAtIndex(int index, int val) {
      if (index > size || index < 0) {
        return;
      }

      Node node = getNode(index - 1);
      if (node != null) {
        addToNode(new Node(val), node);
      }
    }

    public void deleteAtIndex(int index) {
      if (index < 0) {
        return;
      }

      Node node = getNode(index);
      if (node != null) {
        node.prev.next = node.next;
        if (node.next != null) {
          node.next.prev = node.prev;
        }
        size--;
      }
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
