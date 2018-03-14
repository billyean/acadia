from unittest import TestCase
from maths.sort_int import SortInt

class TestSortInt(TestCase):
    def test_ones_quick(self):
        si = SortInt()
        l = [1,2,3,4,5,6,7,8,9,10]
        l.sort(key=si.ones_quick)
        self.assertEqual(l, [1,2,4,8,3,5,6,9,10,7])

    def test_ones_slow(self):
        si = SortInt()
        l = [1,2,3,4,5,6,7,8,9,10]
        l.sort(key=si.ones_slow)
        self.assertEqual(l, [1,2,4,8,3,5,6,9,10,7])