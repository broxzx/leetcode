from typing import List


class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        numbers = dict()

        def countBits(num) -> int:
            ones = 0

            while num > 0:
                if num % 2 == 1:
                    ones += 1
                num = num >> 1

            return ones

        for number in arr:
            bits = countBits(number)
            numbers[number] = bits

        arr = sorted(arr, key=lambda x: (numbers[x], x))

        return arr

if __name__ == '__main__':
    sol = Solution()
    print(sol.sortByBits([1024,512,256,128,64,32,16,8,4,2,1]))