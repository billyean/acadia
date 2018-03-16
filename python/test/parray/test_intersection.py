from unittest import TestCase
from parray.intersection import Intersection

class TestIntersection(TestCase):
    def test_intersect1(self):
        i = Intersection()
        self.assertEqual(1, i.intersectNum([[1,2,3],[3,4,5],[3,9,10]]))