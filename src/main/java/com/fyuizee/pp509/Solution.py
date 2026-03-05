class Solution:
    def fib(self, n: int) -> int:
        if n == 0:
            return 0
        elif n == 1:
            return 1

        prev = 1
        cur = prev
        for i in range(2,n):
            prevprev = prev
            prev = cur
            cur = prevprev + prev

        return cur