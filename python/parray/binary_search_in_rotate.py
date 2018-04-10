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

class BinarySearchInRotate:
    def search(self, l, v, s, e):
        if s < e:
            m = (s + e) // 2

            if l[m] == v:
                return m
            elif l[s] < l[m]:
                if e < l[s]:
                    self.search(l, v, m + 1, e)
                else:
                    self.search(l, v, m - 1, e)
            else:
                if e > l[e]:
                    self.search(l, v, m - 1, e)
                else:
                    self.search(l, v, m + 1, e)


