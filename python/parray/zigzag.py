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

class Zigzag:
    def convert(self, s, numRows):
        if numRows < 2 or len(s) == 0:
            return s

        zs = ""

        for i in range(0, numRows):
            span1 = 2 * (numRows - i - 1)
            span2 = 2 * i

            add = True

            b = i

            while b < len(s):
                zs += s[b]

                if span1 == 0:
                    b += span2
                elif span2 == 0:
                    b += span1
                elif add:
                    b += span1
                else:
                    b += span2

                add = not add


        return zs