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

class SingleNumber:
    def find_in_twos(self, nums):
        s = 0
        for i in nums:
            s ^= i
        return s

    # [0 0 0] => [0 0]
    # [1 0 0] => [1 0]
    # [0 1 0] => [1 0]
    # [1 1 0] => [0 1]
    # [0 1 1] => [0 0]
    def find_in_threes(self, nums):
        one = 0
        two = 0

        for i in nums:
            two |= one & i
            one ^= i
            three = one & two
            one &= ~three
            two &= ~three

        return one

    # [0 0 0 0] => [0 0 0]
    # [1 0 0 0] => [1 0 0]
    # [0 1 0 0] => [1 0 0]
    # [1 1 0 0] => [0 1 0]
    # [0 0 1 0] => [0 1 0]
    # [1 0 1 0] => [0 0 1]
    # [0 0 0 1] => [0 0 1]
    # [1 0 0 1] => [0 0 0]
    def find_in_fours(self, nums):
        one = 0
        two = 0

        for i in nums:
            two |= one & i
            one ^= i
            three = one & two
            four =  three & ~one
            one &= ~four
            two &= ~four
            three &= four

        return one