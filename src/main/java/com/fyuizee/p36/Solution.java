package com.fyuizee.p36;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {

  }

  public boolean isValidSudoku(char[][] nums) {
    Set<Integer> rows = new HashSet<>();

    for (char[] num : nums) {
      for (int j = 0; j < nums.length; j++) {
        if (num[j] != '.' && !rows.add(Character.getNumericValue(num[j]))) {
          return false;
        }
      }
      rows.clear();
    }

    Set<Integer> columns = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (nums[j][i] != '.' && !columns.add(Character.getNumericValue(nums[j][i]))) {
          return false;
        }
      }
      columns.clear();
    }

    Set<Integer> uniqueBoxes = new HashSet<>();
    for (int i = 0; i < nums.length; i += 3) {
      for (int j = 0; j < nums.length; j += 3) {
        for (int k = 0; k < 3; k++) {
          for (int l = 0; l < 3; l++) {
            char val = nums[i + k][j + l];
            if (val != '.' && !uniqueBoxes.add(Character.getNumericValue(val))) {
              return false;
            }
          }
        }
        uniqueBoxes.clear();
      }
    }

    return true;
  }

}
