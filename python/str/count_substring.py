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

class SubString:
    def kmp_index(self, string):
        l = len(string)
        kmp_index = [0] * l
        kmp_index[0] = 0
        pos = 0

        for i in range(1, l):
            while (pos > 0 and string[pos] != string[i]):
                pos = kmp_index[pos - 1]
            if (string[pos] == string[i]):
                pos += 1
            kmp_index[i] = pos

        return kmp_index

    def count_substring(self, string, sub_string):
        n = 0
        lp = self.kmp_index(sub_string)

        k = 0
        for i, c in enumerate(string):
            if c == sub_string[k]:
                k += 1
            else:
                k = lp[k]
            if k == len(sub_string):
                n += 1
                k = lp[k - 1]
        return n







