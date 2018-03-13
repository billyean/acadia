from unittest import TestCase
from array.rotate import Rotate

class TestRotate(TestCase):
    def test_rotate_0(self):
        r = Rotate()
        self.assertEqual(r.rotate_right([0, 1, 2, 3, 4, 5, 6, 7], 0),
                         [0, 1, 2, 3, 4, 5, 6, 7])

    def test_rotate_1(self):
        r = Rotate()
        self.assertEqual(r.rotate_right([0, 1, 2, 3, 4, 5, 6, 7], 1),
                         [7, 0, 1, 2, 3, 4, 5, 6])

    def test_rotate_half(self):
        r = Rotate()
        self.assertEqual(r.rotate_right([0, 1, 2, 3, 4, 5, 6, 7], 4),
                         [4, 5, 6, 7, 0, 1, 2, 3])


    def test_rotate_len(self):
        r = Rotate()
        self.assertEqual(r.rotate_right([0, 1, 2, 3, 4, 5, 6, 7], 8),
                         [0, 1, 2, 3, 4, 5, 6, 7])

    def test_rotate_more_than_len(self):
        r = Rotate()
        self.assertEqual(r.rotate_right([0, 1, 2, 3, 4, 5, 6, 7], 9),
                         [7, 0, 1, 2, 3, 4, 5, 6])