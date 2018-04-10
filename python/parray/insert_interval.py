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

class InsertInterval:
    def insert(self, l, i):
        sorted(l, key=lambda t: (t[1], t[0]))

        nl = []
        low = i[0]
        up = i[1]

        for interval in l:
            if interval[1] < i[0]:
                nl += [interval]
            elif interval[0] > i[1]:
                nl += [(low, up)]
                nl += [interval]
            else:
                low = min(interval[0], low)
                up = max(interval[1], up)

        if nl[-1][1] < low:
            nl += [(low, up)]

        return nl
