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

import numpy as np

class Fibonnaci:
    def __init__(self):
        a = [[1, 1], [1, 0]]
        self._cache = {1:np.array(a)}
        k = 1
        for i in range(2, 8):
            n = self._cache[k].dot(self._cache[k])
            k *= 2
            print(k)
            self._cache[k] = n

    def nth(self, n):
        if n == 1 or n == 2:
            return 1
        n -= 1
        v = n & -n
        m = self._cache[v]
        n -= v

        while n != 0:
            v = n & -n
            m = m.dot(self._cache[v])
            n -= v

        return m[0][0]