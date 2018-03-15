from unittest import TestCase
from datastructure.min_stack import MinStack

class TestMinStack(TestCase):
    def test_stack(self):
        stack = MinStack()

        stack.push(3)
        stack.push(1)
        stack.push(5)

        self.assertEqual(1, stack.min())
        self.assertEqual(5, stack.top())

        stack.push(0)

        self.assertEqual(0, stack.min())
        self.assertEqual(0, stack.top())

        stack.pop()
        self.assertEqual(1, stack.min())
        self.assertEqual(5, stack.top())
