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

class ReverseVowels:
    def reverse(self, s):
        i = 0
        j = len(s) - 1

        while i < j:
            while i < j and s[i] not in ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']:
                i += 1

            while i < j and s[j] not in ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']:
                j -= 1

            if i != j:
                l = s[i]
                r = s[j]
                s = s[:i] + r + s[i+1:j] + l + s[j+1:]
                i += 1
                j -= 1

        return s