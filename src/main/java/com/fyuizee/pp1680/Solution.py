class Solution:
    def concatenatedBinary(self, n: int) -> int:
        s = ''
        for i in range(1, n + 1):
            s += bin(i)[2:]
        x = int(s,2)
        return x % (10 ** 9 + 7)

if __name__ == '__main__':
    sol = Solution()
    print(sol.concatenatedBinary(12))