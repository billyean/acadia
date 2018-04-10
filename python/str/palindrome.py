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

class Palindrome:
    def is_palindrome(self, s):
        half = len(s) // 2
        return s[0:half] == s[:-(half+1):-1]

    def allPairs(self, words):
        pairs = []
        for i, iw in enumerate(words):
            for j, jw in enumerate(words):
                if i != j and self.is_palindrome(iw + jw):
                    pairs.append([i, j])

        return pairs