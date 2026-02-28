from collections import defaultdict, deque
from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        in_degree = defaultdict(int)
        graph = defaultdict(list)

        for a,b in prerequisites:
            graph[b].append(a)
            in_degree[a] += 1

        queue = deque()
        for course in range(numCourses):
            if in_degree[course] == 0:
                queue.append(course)

        res = []
        while queue:
            course = queue.popleft()
            res.append(course)

            for related_course in graph[course]:
                in_degree[related_course] -= 1
                if in_degree[related_course] == 0:
                    queue.append(related_course)

        if len(res) == numCourses:
            return res
        else:
            return []