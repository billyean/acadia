from unittest import TestCase

from tree.tree2str import TreeStr

class TestTreeStr(TestCase):
    def test_tree2str(self):
        tree = TreeStr()
        self.assertEqual(tree.tree2str())
