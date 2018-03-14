from unittest import TestCase
from parray.zigzag import Zigzag


class TestZigzag(TestCase):
    def test_convert(self):
        z = Zigzag()
        self.assertEqual("ACB", z.convert("ABC", 2))