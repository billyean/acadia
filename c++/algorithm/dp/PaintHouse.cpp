//Copyright [2018] [Haibo Yan]
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

//
// Created by Haibo Yan on 4/1/18.
//

#include "PaintHouse.h"
#include <climits>

int PaintHouse::minCost(vector<vector<int>> costs) {
    int mi_1 = -1;

    int min_1 = INT_MAX, min_2 = INT_MAX;

    for (auto ic = costs.begin(); ic != costs.end(); ic++) {
        vector<int> line = *ic;
        int lmi_1 = -1;
        int lmin_1 = INT_MAX, lmin_2 = INT_MAX;
        for (int j = 0; j < line.size(); j++) {
            int v = (j == mi_1 ? min_2 : min_1) + line[j];
            if (v <= lmin_1) {
                lmin_2 = lmin_1;
                lmin_1 = v;
                lmi_1 = j;
            } else if (v < lmin_2) {
                lmin_2 = v;
            }
        }
        min_1 = lmin_1;
        min_2 = lmin_2;
        mi_1 = lmi_1;
    }

    return min_1;
}
