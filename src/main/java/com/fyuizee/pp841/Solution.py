from typing import List


class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        def dfs(key):
            room = rooms[key]
            for key in room:
                if key not in seen:
                    seen.add(key)
                    dfs(key)

        seen = {0}
        dfs(0)
        return len(seen) == len(rooms)


if __name__ == '__main__':
    sol = Solution()
    sol.canVisitAllRooms([[1], [2], [3], []])
