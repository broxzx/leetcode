package com.fyuizee.p2799;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public int countCompleteSubarrays(int[] nums) {
    int left = 0, res = 0;
    Set<Integer> set = new HashSet<>();

    for (int i : nums) {
      set.add(i);
    }

    int distinct = set.size();
    Map<Integer, Integer> mpp = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
      while (mpp.size() == distinct) {
        res += nums.length - i;
        mpp.put(nums[left], mpp.get(nums[left]) - 1);
        if (mpp.get(nums[left]) == 0) mpp.remove(nums[left]);
        left++;
      }
    }
    return res;
  }
}
