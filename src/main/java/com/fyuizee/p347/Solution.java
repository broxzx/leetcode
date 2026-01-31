package com.fyuizee.p347;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {

  }

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> res = new HashMap<>();


    for (int i : nums) {
      res.put(i, res.getOrDefault(i, 0) + 1);
    }

    List<Integer> list = res.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
      .limit(k)
      .map(Map.Entry::getKey)
      .toList();

    int[] rofl = new int[k];

    for (int i = 0; i < k; i++) {
      rofl[i] = list.get(i);
    }

    return rofl;
  }

}
