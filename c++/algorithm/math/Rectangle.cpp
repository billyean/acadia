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
// Created by Haibo Yan on 5/22/18.
//

#include "Rectangle.h"
#include <tuple>
#include <set>
#include <sstream>
#include <iostream>
#include <climits>

bool Rectangle::isPerfect(vector<vector<int>> rectangles) {
    int l = INT_MAX, r = 0, b = INT_MAX, t = 0;

    set<string> points;

    int calArea = 0;

    for (auto irect = rectangles.begin(); irect != rectangles.end(); irect++) {
        vector<int> rect = *irect;
        int rb = rect[0];
        int rl = rect[1];
        int rt = rect[2];
        int rr = rect[3];

        int rectArea = (rt - rb) * (rr - rl);
        calArea += rectArea;


        vector<string> corners;
        ostringstream stream1;
        stream1 << rb << "#" << rl;
        corners.push_back(stream1.str());
        ostringstream stream2;
        stream2 << rb << "#" << rr;
        corners.push_back(stream2.str());
        ostringstream stream3;
        stream3 << rt << "#" << rl;
        corners.push_back(stream3.str());
        ostringstream stream4;
        stream4 << rt << "#" << rr;
        corners.push_back(stream4.str());

        for (auto ic = corners.begin(); ic != corners.end(); ic++) {
            auto p = *ic;
            if(!(points.insert(p).second)) {
                points.erase(p);
            }
        }

        l = min(l, rl);
        r = max(r, rr);
        b = min(b, rb);
        t = max(t, rt);
    }

    int area = (r - l) * (t - b);

    set<string> corners;
    ostringstream stream1;
    stream1 << b << "#" << l;
    corners.insert(stream1.str());
    ostringstream stream2;
    stream2 << b << "#" << r;
    corners.insert(stream2.str());
    ostringstream stream3;
    stream3 << t << "#" << l;
    corners.insert(stream3.str());
    ostringstream stream4;
    stream4 << t << "#" << r;
    corners.insert(stream4.str());

    return calArea == area && points == corners;
}