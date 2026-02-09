package com.fyuizee.p1382;

import com.fyuizee.utils.TreeNode;
import com.fyuizee.utils.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 */
public class Solution {

  public TreeNode balanceBST(TreeNode root) {
    List<Integer> nums = new ArrayList<>();
    traverse(root, nums);

    return construct(nums, 0, nums.size() - 1);
  }

  private void traverse(TreeNode node, List<Integer> nums) {
    if (node == null) {
      return;
    }

    traverse(node.left, nums);
    nums.add(node.val);
    traverse(node.right, nums);
  }

  private TreeNode construct(List<Integer> nums, int left, int right) {
    if (left > right) {
      return null;
    }

    int mid = (left + right) / 2;
    TreeNode node = new TreeNode(nums.get(mid));
    node.left = construct(nums, left, mid - 1);
    node.right = construct(nums, mid + 1, right);

    return node;
  }
}
