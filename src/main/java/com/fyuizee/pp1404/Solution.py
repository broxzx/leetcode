class Solution:
    def numSteps(self, s: str) -> int:
        res = 0

        while s != '1':
            print(int(s,2))
            if s[-1] == '1':
                s = self.add_one(s)
            else:
                s = self.divide(s)
            res += 1

        return res

    def add_one(self, s) -> str:
        index = 0
        for i, e in reversed(list(enumerate(s))):
            if e == '0':
                index = i
                break

        if index == 0:
            to = len(s) - index
        else:
            to = len(s) - index - 1
        return s[:index] + '1' + ('0' * to)

    def divide(self, s) -> str:
        s = s[:-1]
        return s

if __name__ == '__main__':
    sol = Solution()
    print(sol.numSteps("1101"))