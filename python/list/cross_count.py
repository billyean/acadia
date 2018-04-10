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

#!/usr/bin/env python3

"""
Given an unsorted array. for example [3, 2, 1, 4, 5].
Sort the array, we have new array [1, 2, 3, 4, 5],
if we draw the line between the 2 arrays for the same number, for example:

[3, 2, 1, 4, 5]
  \ | /
   \|/
  / | \
[1, 2, 3, 4, 5]
then we have 3 line-cross:

line (1 to 1) cross line (2 to 2)
line (1 to 1) cross line (3 to 3)
line (2 to 2) cross line (3 to 3)
Note: the line between two 4s and the line between two 5s don't cross any other lines;

Implement the algorithm to calculate the how many line crosses for an unsorted array.
"""

def number_of_cross(list):
    sl = list[:]
    sl.sort()

    noCross = 0

    for i in range(len(list)):
        if sl[i] == list[i]:
            allLess = True
            for j in range(i):
                if list[j] > list[i]:
                    allLess = False
                    break

            if allLess:
                noCross = noCross + 1

    return len(list) - noCross

if __name__ == "__main__":
    print(number_of_cross([3, 2, 1, 4, 5]))
    print(number_of_cross([1, 2, 3, 4, 5]))