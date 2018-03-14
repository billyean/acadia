from unittest import TestCase

from str.kmp import KMP

class TestKMP(TestCase):
    def test_kmp(self):
        kmp = KMP()
        self.assertEqual(-1, kmp.kmp("BAAAB", "AAAA"))
