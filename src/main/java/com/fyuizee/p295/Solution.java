package com.fyuizee.p295;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);    // arr = [1]
    medianFinder.addNum(2);    // arr = [1, 2]
    System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
    medianFinder.addNum(3);    // arr[1, 2, 3]
    System.out.println(medianFinder.findMedian()); // return 2.0
  }

  static class MedianFinder {

    Queue<Integer> min = new PriorityQueue<>((o1, o2) -> o2 - o1);
    Queue<Integer> max = new PriorityQueue<>();


    public void addNum(int num) {
      min.add(num);
      max.add(min.poll());

      if (max.size() > min.size()) {
        min.add(max.poll());
      }
    }

    public double findMedian() {
      if (min.size() > max.size()) {
        return min.peek();
      }

      return (double) (min.peek() + max.peek()) / 2;
    }
  }

}
