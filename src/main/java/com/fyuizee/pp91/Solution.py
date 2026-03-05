class Solution:
    def numDecodings(self, s: str) -> int:
        memo = {}

        def inner(cur: str):
            if cur in memo:
                return memo[cur]

            if len(cur) == 0:
                memo[cur] = 1
                return 1

            if cur[0] == "0":
                memo[cur[0]] = 0
                return 0

            if len(cur) == 1:
                memo[cur] = 1
                return 1

            if cur[:2] > "26":
                inner_1 = inner(cur[1:])
                memo[cur] = inner_1
                return inner_1
            inner_1 = inner(cur[1:])
            inner_2 = inner(cur[2:])
            memo[cur[1:]] = inner_1
            memo[cur[2:]] = inner_2
            return inner_1 + inner_2

        return inner(s)