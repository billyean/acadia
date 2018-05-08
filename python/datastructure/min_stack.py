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

class MinStack:
    def __init__(self):
        self._stack = []

    def push(self, e):
        if len(self._stack) == 0:
            self._stack.append((e, e))
        else:
            m = min(self._stack[-1][1], e)
            self._stack.append((e, m))

    def pop(self):
        l = self._stack.pop(-1)
        return l[0]

    def top(self):
        return self._stack[-1][0]

    def empty(self):
        return len(self._stack) == 0

    def min(self):
        return self._stack[-1][1]