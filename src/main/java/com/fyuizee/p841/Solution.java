package com.fyuizee.p841;

import java.util.*;

public class Solution {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<List<Integer>> seen = new HashSet<>();
    Set<Integer> opened = new HashSet<>();
    Queue<List<Integer>> q = new LinkedList<>();

    q.add(rooms.get(0));
    seen.add(rooms.get(0));
    opened.add(0);

    while (!q.isEmpty()) {
      List<Integer> accessible = q.remove();

      opened.addAll(accessible);
      for (int i : accessible) {
        List<Integer> cur = rooms.get(i);
        if (seen.add(cur)) {
          q.add(cur);
        }
      }
    }

    System.out.println(opened);
    return opened.size()  == rooms.size();
  }
}
