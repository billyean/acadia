#!/usr/bin/env python3

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