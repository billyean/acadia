from unittest import TestCase
from parray.insert_interval import InsertInterval

class TestInsertInterval(TestCase):
    def test_insert1(self):
        ii = InsertInterval()

        self.assertEqual([(1, 5), (6, 9)], ii.insert([(1, 3), (6, 9)], (2, 5)))

    def test_insert2(self):
        ii = InsertInterval()

        self.assertEqual([(1, 2), (3, 10), (12, 16)],
                         ii.insert([(1, 2), (3, 5), (6, 7), (8, 10), (12, 16)], (4, 9)))