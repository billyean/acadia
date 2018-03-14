from unittest import TestCase
from str.isomorphic import Isomorphic

class TestRotate(TestCase):
    def test_isomorphic1(self):
        i = Isomorphic()
        self.assertTrue(i.isomorphic("abc", "abc"))

    def test_isomorphic2(self):
        i = Isomorphic()
        self.assertTrue(i.isomorphic("abc", "bac"))

    def test_isomorphic3(self):
        i = Isomorphic()
        self.assertTrue(i.isomorphic("abca", "aacb"))

    def test_not_isomorphic4(self):
        i = Isomorphic()
        self.assertFalse(i.isomorphic("abca", "abcb"))