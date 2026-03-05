from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = set()

        def backtracking(cur, open_par):
            if len(cur) == n * 2:
                if open_par == 0:
                    res.add(cur[:])
                return

            if open_par > 0:
                backtracking(cur + ')', open_par - 1)

            if open_par + 1 <= n:
                backtracking(cur + '(', open_par + 1)


        backtracking('(', 1)
        return list(res)

if __name__ == '__main__':
    sol = Solution()
    print(sol.generateParenthesis(3))