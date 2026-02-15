package com.fyuizee.p140;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<String> strings = solution.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
    System.out.println(strings);
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> res = new ArrayList<>();
    helper(s, wordDict, res, new StringBuilder());
    return res;
  }

  private void helper(String s, List<String> wordDict, List<String> res, StringBuilder cur) {
    if (s.isEmpty()) {
      res.add(cur.toString().trim());
    }

    for (String word : wordDict) {
      if (s.startsWith(word)) {
        String substring = s.substring(word.length());

        StringBuilder string = new StringBuilder(cur.toString()).append(word).append(" ");
        helper(substring, wordDict, res, string);
      }
    }
  }

}
