package com.fyuizee.p71;

import java.util.Arrays;
import java.util.Stack;

/**
 * Soltuion
 */
public class Soltuion {

  public static void main(String[] args) {
    System.out.println(simplifyPath("/../"));
  }

  public static String simplifyPath(String path) {
    if (path.isEmpty() || !path.startsWith("/")) {
      return path;
    } else if (path.matches("/+")) {
      return "/";
    }

    String[] paths = path.split("/+");
    System.out.println(Arrays.toString(paths));
    Stack<String> stack = new Stack<>();

    for (String s : paths) {
      if (s.isEmpty() || s.isBlank()) {
        continue;
      }

      if (s.equals("..") && !stack.isEmpty()) {
        stack.pop();
      } else if (s.equals("..")) {
        stack.push("");
      } else if (!s.equals(".")) {
        stack.push(s);
      }
    }

    StringBuilder res = new StringBuilder();
    for (String s : stack) {
      res.append("/").append(s);
    }

    return res.isEmpty() ? "/" : res.toString().replaceAll("/+", "/");
  }
}
