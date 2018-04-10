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

class Duplicate:
    def remove(self, nums):
        l = len(nums)
        if l < 2:
            return l

        p = 0
        for i in range(1, l):
            if nums[p] != nums[i]:
                p += 1
                nums[p] = nums[i]
        return p + 1

    def removeAtMostTwice(self, nums):
        map = {}

        l = len(nums)
        if l < 2:
            return l

        newLen = 1
        map[nums[0]] = 1

        for i in range(1, l):
            n = nums[i]
            if n not in map:
                nums[newLen] = nums[i]
                map[n] = 1
                newLen += 1
            elif map[n] == 1:
                nums[newLen] = nums[i]
                map[n] += 1
                newLen += 1

        return newLen