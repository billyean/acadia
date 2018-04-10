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

class KMP:
    def kmp(self, s, p):
        lp = self.pattern_index(p)

        k = 0
        for si, sc in enumerate(s):
            if sc == p[k]:
                k = k + 1
            else:
                k = lp[k]
            if k == len(p):
                return si - k + 1

        return -1


    def pattern_index(self, p):
        if not p:
            return []

        indexes = [0]
        k = 0
        for i in range(1, len(p)):
            c = p[i]
            while k > 0 and p[k] != c:
                k = indexes[k - 1]

            if p[k] == c:
                k = k + 1

            indexes.append(k)
        return indexes
