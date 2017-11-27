#!/usr/bin/env python3
# https://leetcode.com/problems/construct-string-from-binary-tree

"""
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis
pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the
output.

"""


class Solution:
    def tree2str(self, t):
        """
        :type t: TreeNode
        :rtype: str
        """
        if t == None:
            return ''

        left = self.tree2str(t.left)
        right = self.tree2str(t.right)

        if left == '' and right == '':
            return str(t.val)
        elif right == '':
            return str(t.val) + '(' + left + ')'
        elif left == '':
            return str(t.val) + '()(' + right + ')'
        else:
            return str(t.val) + '(' + left + ')(' + right + ')'