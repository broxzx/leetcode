from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []

        def backtracking(cur, from_i):
            if len(cur) == k:
                res.append(list(cur))
                return

            for i in range(from_i + 1, n + 1):
                cur.append(i)
                backtracking(cur, i)
                cur.pop()

        backtracking([], 0)
        return res