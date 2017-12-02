from unittest import TestCase

from str.kmp import KMP

class TestKMP(TestCase):
    def test_kmp(self):
        kmp = KMP()
        self.assertEqual(kmp.kmp("BAAAB", "AAAA"), -1)
