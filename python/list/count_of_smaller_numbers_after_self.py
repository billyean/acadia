# Copyright [2018] [Haibo Yan]
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Here is the story
# https://www.linkedin.com/pulse/software-engineer-detained-several-hours-us-customs-given-fairchild


"""
You are given an integer array nums and you have to return a new counts array. The counts array has the property where
counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
"""
class CountSmaller:
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        index_value = [[idx,0,val] for idx, val in enumerate(nums)]

        return [count for (index, count, val) in sorted(self.merge_sort(index_value, 1))]


    def merge_sort(self, index_value, s):
        merged = []
        l = len(index_value)
        if s >= l:
            return index_value


        b = 0
        while b < l:
            i, j = 0, 0
            while i < s and j < s and b + s + j < l:
                if index_value[b + i][2] <= index_value[b + s + j][2]:
                    index_value[b + i][1] = index_value[b + i][1] + j
                    merged.append(index_value[b + i])
                    i = i + 1
                else:
                    merged.append(index_value[b + s + j])
                    j = j + 1

            while b + i < l and i < s:
                index_value[b + i][1] = index_value[b + i][1] + j
                merged.append(index_value[b + i])
                i = i + 1

            while b + s + j < l and j < s:
                merged.append(index_value[b + s + j])
                j = j + 1

            b = b + 2 * s

        print(merged)
        return self.merge_sort(merged, 2 * s)