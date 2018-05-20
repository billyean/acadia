from unittest import TestCase
from maths.sum import Sum

class TestSum(TestCase):
    def test4Sum(self):
        s = Sum()
        self.assertEqual([[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]], s.fourSum([1, 0, -1, 0, -2, 2], 0))

