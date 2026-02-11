package com.fyuizee.p98;

import com.fyuizee.utils.TreeNode;
import com.fyuizee.utils.TreeNodeUtil;

public class Solution {

  private long minVal = Long.MIN_VALUE;

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (!isValidBST(root.left)) {
      return false;
    }

    if (minVal >= root.val) {
      return false;
    }

    minVal = root.val;

    return isValidBST(root.right);
  }
}
