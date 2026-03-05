class Solution:
    def minPartitions(self, n: str) -> int:
        res = 0

        for c in n:
            res = max(res, int(c))

        return res
if __name__ == '__main__':
    sol = Solution()
    print(sol.minPartitions("82734"))