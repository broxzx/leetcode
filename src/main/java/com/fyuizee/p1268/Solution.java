package com.fyuizee.p1268;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<List<String>> res = solution.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
    System.out.println(res);

    // [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
    // [[mobile, moneypot, monitor], [mobile, moneypot, monitor], [mouse, mousepad], [mouse, mousepad], [mouse, mousepad]]
  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie trie = new Trie();
    for (String product : products) {
      trie.insert(product);
    }

    List<List<String>> res = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : searchWord.toCharArray()) {
      stringBuilder.append(c);
      List<String> words = trie.startsWith(stringBuilder.toString());

      words.sort(String::compareTo);

      res.add(words.subList(0, Math.min(words.size(), 3)));
    }

    return res;
  }

  class Trie {

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
      TrieNode cur = root;

      for (char c : word.toCharArray()) {
        cur.children.computeIfAbsent(c, k -> new TrieNode());
        cur = cur.children.get(c);
        cur.words.add(word);
      }

    }

    public List<String> startsWith(String prefix) {
      TrieNode cur = root;

      for (char c : prefix.toCharArray()) {
        if (cur.children.containsKey(c)) {
          cur = cur.children.get(c);
        } else {
          return new ArrayList<>();
        }
      }

      return cur.words;
    }


    static class TrieNode {
      Map<Character, TrieNode> children;
      List<String> words;

      public TrieNode() {
        this.children = new HashMap<>();
        this.words = new ArrayList<>();
      }
    }
  }


}
