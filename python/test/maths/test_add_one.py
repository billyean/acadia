from unittest import TestCase
from maths.add_one import AddOne

class TestAddOne(TestCase):
    def test_add_no_carrier(self):
        ao = AddOne()
        self.assertEquals([1, 1, 2], ao.add_one([1, 1, 1]))

    def test_add_has_one_carrier(self):
        ao = AddOne()
        self.assertEquals([1, 2, 0], ao.add_one([1, 1, 9]))

    def test_add_has_many_carrier(self):
        ao = AddOne()
        self.assertEquals([2, 0, 0, 0], ao.add_one([1, 9, 9, 9]))

    def test_add_has_middle_carrier(self):
        ao = AddOne()
        self.assertEquals([1, 8, 0, 0], ao.add_one([1, 7, 9, 9]))

    def test_add_has_highest_carrier(self):
        ao = AddOne()
        self.assertEquals([1, 0, 0, 0, 0], ao.add_one([9, 9, 9, 9]))