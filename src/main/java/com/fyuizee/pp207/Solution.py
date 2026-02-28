from collections import defaultdict, deque
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        in_degree = defaultdict(int)
        graph = defaultdict(list)

        for a,b in prerequisites:
            graph[b].append(a)
            in_degree[a] += 1

        queue = deque()
        for course in range(numCourses):
            if in_degree[course] == 0:
                queue.append(course)

        n = 0
        while queue:
            course = queue.popleft()
            n += 1

            for related_course in graph[course]:
                in_degree[related_course] -= 1
                if in_degree[related_course] == 0:
                    queue.append(related_course)

        return n == numCourses

if __name__ == '__main__':
    sol = Solution()
    print(sol.canFinish(numCourses = 5, prerequisites = [[1,4],[2,4],[3,1],[3,2]]))
    # print(sol.canFinish(numCourses = 2, prerequisites = [[1,0]]))
    # print(sol.canFinish(numCourses = 1, prerequisites = []))
    # print(sol.canFinish(numCourses = 3, prerequisites = [[1,0]]))

# 1 -> [4]
# 2 -> [4]
# 3 -> [1]
# 3 -> [2]