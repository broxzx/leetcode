from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        def backtracking(cur, index):
            if cur not in res:
                res.append(list(cur))

            if len(cur) >= len(nums):
                return

            for i in range(index + 1, len(nums)):
                cur.append(nums[i])
                backtracking(cur, i)
                cur.pop()

        backtracking([], -1)
        return res

if __name__ == '__main__':
    sol = Solution()
    print(sol.subsets(nums = [1,2,3]))