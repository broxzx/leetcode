package com.fyuizee.p96;

import java.util.HashSet;
import java.util.Set;

import com.fyuizee.utils.TreeNode;

/**
 * Solution
 */
public class Solution {

  private int sum = 0;

  public int numTrees(int n) {
    numTrees(null, null, n);

    return sum;
  }

  private void numTrees(TreeNode node, Set<Integer> contains, int n) {
    for (int i = 1; i <= n; i++) {
      if (node == null) {
        sum++;
        numTrees(new TreeNode(i), new HashSet<>(Set.of(i)), n);
      } else {
        HashSet<Integer> set = new HashSet<>(contains);
        set.add(i);
        numTrees(node, set, n);
      }
    }
  }

  private TreeNode copy(TreeNode src, TreeNode dst) {

  }
}
