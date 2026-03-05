from typing import List


class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        res = []

        def generate(cur, sum, index):
            if len(cur) >= k:
                if sum == n and cur not in res :
                    res.append(list(cur))
                return

            for i in range(index, 10):
                if i not in cur and sum + i <= n:
                    cur.append(i)
                    generate(cur, sum + i, i + 1)
                    cur.pop()

        generate([], 0, 1)

        return res

if __name__ == '__main__':
    sol = Solution()
    print(sol.combinationSum3(3,9))