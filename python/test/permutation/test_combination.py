from unittest import TestCase

from permutation.combination import Combination


class TestCombination(TestCase):
    def test_combination(self):
        combination = Combination()
        self.assertEqual(combination.combination([["Catfish", "Salmon"], ["Beef", "Pork", "Chicken", "Duck"],
                                                  ["Lettuce", "Cabbage", "Carrot"]]),
                         [['Catfish', 'Beef', 'Lettuce'], ['Catfish', 'Beef', 'Cabbage'], ['Catfish', 'Beef', 'Carrot'],
                          ['Catfish', 'Pork', 'Lettuce'], ['Catfish', 'Pork', 'Cabbage'], ['Catfish', 'Pork', 'Carrot'],
                          ['Catfish', 'Chicken', 'Lettuce'], ['Catfish', 'Chicken', 'Cabbage'],
                          ['Catfish', 'Chicken', 'Carrot'], ['Catfish', 'Duck', 'Lettuce'],
                          ['Catfish', 'Duck', 'Cabbage'], ['Catfish', 'Duck', 'Carrot'], ['Salmon', 'Beef', 'Lettuce'],
                          ['Salmon', 'Beef', 'Cabbage'], ['Salmon', 'Beef', 'Carrot'], ['Salmon', 'Pork', 'Lettuce'],
                          ['Salmon', 'Pork', 'Cabbage'], ['Salmon', 'Pork', 'Carrot'], ['Salmon', 'Chicken', 'Lettuce'],
                          ['Salmon', 'Chicken', 'Cabbage'], ['Salmon', 'Chicken', 'Carrot'],
                          ['Salmon', 'Duck', 'Lettuce'], ['Salmon', 'Duck', 'Cabbage'], ['Salmon', 'Duck', 'Carrot']]
                         )

    def test_combine(self):
        combination = Combination()

        self.assertEqual([[1, 2], [1, 3],[1, 4], [2, 3], [2, 4], [3, 4]], combination.combine(4, 2))