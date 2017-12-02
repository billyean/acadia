from unittest import TestCase
from list.count_of_smaller_numbers_after_self import CountSmaller


class TestCountSmaller(TestCase):
    def test_countSmaller(self):
        counter = CountSmaller()
        self.assertEqual(counter.countSmaller([5, 2, 6, 1]), [2, 1, 1, 0])
        self.assertEqual(counter.countSmaller([0, 1, 2]), [0, 0, 0])
