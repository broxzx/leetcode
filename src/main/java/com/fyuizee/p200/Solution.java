package com.fyuizee.p200;

public class Solution {

  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];

    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          dfs(i, j, grid, visited);
          count++;
        }
      }
    }

    return count;
  }

  private void dfs(int m, int n, char[][] grid, boolean[][] visited) {
    if (grid[m][n] == '1') {
      visited[m][n] = true;
    }

    for (int i = n + 1; i < grid[0].length && grid[m][i] == '1' && !visited[m][i]; i++) {
      dfs(m, i, grid, visited);
    }
    for (int i = n - 1; i >= 0 && grid[m][i] == '1' && !visited[m][i]; i--) {
      dfs(m, i, grid, visited);
    }

    for (int i = m - 1; i >= 0 && grid[i][n] == '1' && !visited[i][n]; i--) {
      dfs(i, n, grid, visited);
    }
    for (int i = m + 1; i < grid.length && grid[i][n] == '1' && !visited[i][n]; i++) {
      dfs(i, n, grid, visited);
    }
  }
}
