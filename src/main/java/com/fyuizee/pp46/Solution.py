from typing import List, Set


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []

        def backtracking(cur: List[int], seen: Set[int]):
            if len(cur) == len(nums):
                res.append(list(cur))
                return

            for i in range(len(nums)):
                if nums[i] not in seen:
                    cur.append(nums[i])
                    seen.add(nums[i])
                    backtracking(cur, seen)
                    cur.pop()
                    seen.remove(nums[i])

        temp = []
        backtracking(temp, set())
        return res

if __name__ == '__main__':
    sol = Solution()
    print(sol.permute(nums = [1,2,3]))