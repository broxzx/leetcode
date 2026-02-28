from collections import defaultdict
from heapq import heappop, heappush
from typing import List


class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start_node: int,
                       end_node: int) -> float:
        graph = defaultdict(list)
        for i in range(len(edges)):
            u,v = edges[i]
            graph[u].append((v, succProb[i]))
            graph[v].append((u, succProb[i]))

        heap = [(-1.0, start_node)]
        distances = {start_node: -1.0}

        while heap:
            dist, node = heappop(heap)
            if node == end_node:
                return -dist

            for ngh, ngh_dist in graph[node]:
                new_dist = -dist * ngh_dist

                if new_dist > distances.get(ngh, float('-inf')):
                    distances[ngh] = new_dist
                    heappush(heap, (-new_dist, ngh))

        return 0

if __name__ == '__main__':
    sol = Solution()
    print(sol.maxProbability(n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start_node = 0, end_node = 2))