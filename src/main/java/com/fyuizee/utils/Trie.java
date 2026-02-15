package com.fyuizee.utils;

import java.util.HashMap;
import java.util.Map;

public class Trie {

  private final TrieNode root = new TrieNode();

  public void insert(String word) {
    TrieNode cur = root;

    for (char c : word.toCharArray()) {
      cur.children.computeIfAbsent(c, k -> new TrieNode());
      cur = cur.children.get(c);
    }

    cur.isEnd = true;
  }

  public boolean search(String word) {
    TrieNode node = find(word);
    return node != null && node.isEnd;
  }

  public boolean startsWith(String prefix) {
    TrieNode cur = root;

    for (char c : prefix.toCharArray()) {
      if (cur.children.containsKey(c)) {
        cur = cur.children.get(c);
      } else {
        return false;
      }
    }

    return true;
  }

  private TrieNode find(String str) {
    TrieNode current = root;

    for (char c : str.toCharArray()) {
      current = current.children.get(c);
      if (current == null) return null;
    }

    return current;
  }

  static class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode(Map<Character, TrieNode> children, boolean isEnd) {
      this.children = children;
      this.isEnd = isEnd;
    }

    public TrieNode() {
      this.children = new HashMap<>();
    }
  }
}
