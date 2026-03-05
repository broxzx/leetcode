from typing import List
from copy import deepcopy

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []


        def backtracking(row, cols, diagonals, t_diagonals, board):
            if row == n:
                res.append(["".join(board[i]) for i in range(n)])
                return

            for col in range(n):
                current_diagonal = row + col
                current_t_diagonal = row - col

                if current_diagonal in diagonals or current_t_diagonal in t_diagonals or col in cols:
                    continue

                cols.add(col)
                diagonals.add(current_diagonal)
                t_diagonals.add(current_t_diagonal)
                board[row][col] = 'Q'
                backtracking(row + 1, cols, diagonals, t_diagonals, deepcopy(board))
                cols.remove(col)
                diagonals.remove(current_diagonal)
                t_diagonals.remove(current_t_diagonal)
                board[row][col] = '.'

        gen_board = [["."] * n for _ in range(n)]
        backtracking(0, set(), set(), set(), gen_board)

        return res

if __name__ == '__main__':
    sol = Solution()
    print(sol.solveNQueens(4))