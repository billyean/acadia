from unittest import TestCase
from misc.valid_anagram import Anagram

class TestAnagram(TestCase):
    def test_validAnagram(self):
        self.assertTrue(Anagram().isAnagram("anagram", "nagaram"))

    def test_invalidAnagram(self):
        self.assertFalse(Anagram().isAnagram("rat", "cat"))