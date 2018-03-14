from unittest import TestCase
from array.zigzag import Zigzag


class TestZigzag(TestCase):
    def test_convert(self):
        z = Zigzag()
        self.assertEqual("ACB", z.convert("ABC", 2))