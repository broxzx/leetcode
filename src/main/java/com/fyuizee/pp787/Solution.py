from collections import defaultdict
from heapq import heappush, heappop
from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = defaultdict(list)

        for u,v,cost in flights:
            graph[u].append((v, cost))

        heap = [(0,0,src)]
        stops = {}

        while heap:
            cost, depth, flight = heappop(heap)

            if depth > k + 1:
                continue
            if flight == dst:
                return cost

            stops[flight] = depth

            for ngh, cost_to_ngh in graph[flight]:
                if ngh not in stops or stops[ngh] >= depth + 1:
                    heappush(heap, (cost + cost_to_ngh, depth + 1, ngh))

        return -1