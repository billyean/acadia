from unittest import TestCase
from str.reverse_vowels import ReverseVowels

class TestReverseVowels(TestCase):
    def test_reverse(self):
        rv = ReverseVowels()
        self.assertEqual("My nami is Trestan", rv.reverse("My name is Tristan"))