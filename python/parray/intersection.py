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

class Intersection:
    def intersectNum(self, arrs):
        map = {}
        n = 0
        for l in arrs:
            for i in l:
                if i in map:
                    map[i].append(n)
                else:
                    map[i] = [n]
            n += 1

        intersect = 0
        for (k, v) in map.items():
            if len(v) == n:
                intersect += 1

        return intersect