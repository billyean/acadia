//
// Created by haibo on 3/19/18.
//

#include "gmock/gmock.h"
#include "gmock/gmock-matchers.h"
#include <vector>
#include "../../algorithm/array/PrintPattern.h"

using namespace std;
using ::testing::ElementsAre;

TEST(PrintPatternTest, patternCheckOn4) {
    vector<vector<int>> p = PrintPattern::pattern(4);

    ASSERT_THAT(p, ElementsAre(vector<int>{1},
                               vector<int>{1, 1},
                               vector<int>{2, 1},
                               vector<int>{1, 2, 1, 1}));
}

TEST(PrintPatternTest, patternCheckOn8) {
    vector<vector<int>> p = PrintPattern::pattern(8);

    ASSERT_THAT(p, ElementsAre(vector<int>{1},
                               vector<int>{1, 1},
                               vector<int>{2, 1},
                               vector<int>{1, 2, 1, 1},
                               vector<int>{1, 1, 1, 2, 2, 1},
                               vector<int>{3, 1, 2, 2, 1, 1},
                               vector<int>{1, 3, 1, 1, 2, 2, 2, 1},
                               vector<int>{1, 1, 1, 3, 2, 1, 3, 2, 1, 1}));
}

