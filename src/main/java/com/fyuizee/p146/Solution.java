package com.fyuizee.p146;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 */
public class Solution {
  class LRUCache {
    int capacity;
    Map<Integer, Node> data;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.data = new HashMap<>(capacity);
      this.head = new Node(0, 0);
      this.tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
    }

    public void remove(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
      node.next = head.next;
      node.prev = head;
      head.next.prev = node;
      head.next = node;
    }

    public int get(int key) {
      if (!data.containsKey(key)) {
        return -1;
      }

      Node node = data.get(key);
      remove(node);
      addToHead(node);
      return node.val;
    }

    public void put(int key, int value) {
      if (data.containsKey(key)) {
        Node node = data.get(key);
        remove(node);
        addToHead(node);
        node.val = value;
        return;
      }

      if (data.size() >= capacity) {
        Node prev = tail.prev;
        remove(prev);
        data.remove(prev.key);
      }

      Node node = new Node(key, value);
      addToHead(node);
      data.put(key, node);
    }
  }

  class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }
}
