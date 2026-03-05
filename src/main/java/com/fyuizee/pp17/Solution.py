from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        comb = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz',
        }

        res = []
        def generate(cur, index):
            if len(cur) == len(digits):
                res.append(cur)
                return

            for i in range(index, len(digits)):
                cur_digit = digits[i]

                for k in comb[cur_digit]:
                    generate(cur + k, i + 1)

        generate('', 0)
        return res