from unittest import TestCase
from parray.duplicate import Duplicate

class TestDuplicate(TestCase):
    def test_remove(self):
        d = Duplicate()
        r = [1, 2, 3, 4, 5]
        o = [1 , 1, 1, 2, 3, 3, 4, 4, 4, 4, 4 , 4, 5]
        self.assertEqual(len(r), d.remove(o))
        for i in range(len(r)):
            self.assertEqual(r[i], o[i])

    def test_at_most_twice(self):
        d = Duplicate()
        r = [1, 1, 2, 3, 3, 4, 4, 5]
        o = [1 , 1, 1, 2, 3, 3, 4, 4, 4, 4, 4 , 4, 5]
        self.assertEqual(len(r), d.removeAtMostTwice(o))
        for i in range(len(r)):
            self.assertEqual(r[i], o[i])