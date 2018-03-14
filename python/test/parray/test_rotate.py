from unittest import TestCase
from parray.rotate import Rotate


class TestRotate(TestCase):
    def test_rotate_0(self):
        r = Rotate()
        self.assertEqual([0, 1, 2, 3, 4, 5, 6, 7],
                         r.rotate_right([0, 1, 2, 3, 4, 5, 6, 7], 0))

    def test_rotate_1(self):
        r = Rotate()
        self.assertEqual([7, 0, 1, 2, 3, 4, 5, 6],
                        r.rotate_right([0, 1, 2, 3, 4, 5, 6, 7], 1))

    def test_rotate_half(self):
        r = Rotate()
        self.assertEqual([4, 5, 6, 7, 0, 1, 2, 3],
                         r.rotate_right([0, 1, 2, 3, 4, 5, 6, 7], 4))


    def test_rotate_len(self):
        r = Rotate()
        self.assertEqual([0, 1, 2, 3, 4, 5, 6, 7],
                         r.rotate_right([0, 1, 2, 3, 4, 5, 6, 7], 8))

    def test_rotate_more_than_len(self):
        r = Rotate()
        self.assertEqual([7, 0, 1, 2, 3, 4, 5, 6],
                         r.rotate_right([0, 1, 2, 3, 4, 5, 6, 7], 9))