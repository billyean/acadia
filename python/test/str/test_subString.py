from unittest import TestCase

from str.count_substring import SubString

class TestSubString(TestCase):
    def test_count_substring(self):
        sub = SubString()
        self.assertEqual(sub.count_substring('ABCDCDC', 'CDC'), 2)
