from unittest import TestCase
from bitop.single_number import SingleNumber

class TestSingleNumber(TestCase):
    def test_find_in_threes(self):
        s = SingleNumber()
        test_data = [1, 1, 0, 1]

        self.assertEqual(0, s.find_in_threes(test_data))

    def test_find_in_fours(self):
        s = SingleNumber()
        test_data = [1, 1, 2, 1, 1]

        self.assertEqual(2, s.find_in_fours(test_data))