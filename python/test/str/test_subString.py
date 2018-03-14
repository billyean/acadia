from unittest import TestCase

from str.count_substring import SubString

class TestSubString(TestCase):
    def test_count_substring(self):
        sub = SubString()
        self.assertEqual(2, sub.count_substring('ABCDCDC', 'CDC'))
