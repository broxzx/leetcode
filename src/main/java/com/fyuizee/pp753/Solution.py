from collections import defaultdict
from heapq import heapify, heappop, heappush
from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = defaultdict(list)
        for src, target, weight in times:
            graph[src].append((target, weight))

        heap = [(0, k)]
        distances = {k: 0}

        while heap:
            cur_dist, node = heappop(heap)
            if cur_dist > distances.get(node, float('inf')):
                continue

            for ngh, n_weight in graph[node]:
                new_dist = cur_dist + n_weight
                if new_dist < distances.get(ngh, float('inf')):
                    distances[ngh] = new_dist
                    heappush(heap, (new_dist, ngh))

        if n != len(distances):
            return -1

        return max(distances.values())

if __name__ == '__main__':
    sol = Solution()
    print(sol.networkDelayTime(times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2))