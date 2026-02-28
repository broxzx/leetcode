from collections import defaultdict, deque
from typing import List


class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        in_degree = {}
        graph = defaultdict(list)

        for recipe, components in zip(recipes, ingredients):
            in_degree[recipe] = len(components)
            for component in components:
                graph[component].append(recipe)

        queue = deque(supplies)
        result = []

        while queue:
            supply = queue.popleft()

            for recipe in graph[supply]:
                in_degree[recipe] -= 1

                if in_degree[recipe] == 0:
                    queue.append(recipe)
                    result.append(recipe)

        return result