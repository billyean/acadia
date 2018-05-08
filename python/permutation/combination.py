# Copyright [2018] [Haibo Yan]
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

class Combination:
    def combination(self, categories):
        indices = [0] * len(categories)
        combinations = []

        combinations.append(self.combination_with_increasing_index(categories, indices))

        while not all([v == 0 for v in indices]):
            combinations.append(self.combination_with_increasing_index(categories, indices))

        return combinations

    def combination_with_increasing_index(self, categories, indices):
        combination = []
        for p, i in enumerate(indices):
            combination.append(categories[p][i])

        pi = len(indices) - 1

        while pi >= 0 and indices[pi] == len(categories[pi]) - 1:
            indices[pi] = 0
            pi -= 1

        if pi >= 0:
            indices[pi] += 1

        return combination

    def combine(self, n, k):
        """ https://leetcode.com/problems/combinations
        Given two integers n and k, return all possible combinations of k numbers out of 1 ... n
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        list = []
        for i in range(n):
            list.append(i + 1)

        return self.combineList(list, k)

    def combineList(self, list, k):

        if len(list) < k:
            return []

        if k == 0:
            return [[]]

        if len(list) == k:
            return [list]

        c = list[0]

        combinations = []

        for l in self.combineList(list[1:], k - 1):
            combinations.append([c] + l)

        for l in self.combineList(list[1:], k):
            combinations.append(l)

        return combinations
