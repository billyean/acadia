from unittest import TestCase
from dp.fibonacci import Fibonnaci

class TestFibonacci(TestCase):
    def fibonacci_test(self):
        result = {
            1:    1,
            2:    1,
            3:    2,
            4:    3,
            5:    5,
            6:    8,
            7:   13,
            8:   21,
            9:   34,
           10:   55,
           11:   89,
           12:  144,
           20: 6765,
        }
        f = Fibonnaci()
        for n, e in result:
            self.assertEqual(e, f.nth(n))