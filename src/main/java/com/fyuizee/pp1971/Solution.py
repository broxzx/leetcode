from typing import List


class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        def dfs(node: int):
            edge = edges[node]

            if edge[1] == destination:
                return True

            if edge[1] not in seen:
                seen.add(edge[1])
                return dfs(edge[1])

            return False

        seen = {source}
        return dfs(source)
