//
// Created by haibo on 5/11/18.
//

#include "Calls.h"
#include <stack>

vector<tuple<string, int>> Calls::calls(vector<string>& logs) {
    vector<tuple<string, int>> call_list;

//    stack<tuple<string, int, string>> call_stack;
//
//    for (auto it = logs.begin(); it != logs.end(); it++) {
//        string method_entry = *it;
//        auto pi = method_entry.find(',');
//        auto si = method_entry.find(' ', pi + 1);
//
//        string method_name = method_entry.substr(0, pi - 1);
//        int t = atoi(method_entry.substr(pi + 1, si - pi - 1).c_str());
//        string entry_exit = method_entry.substr(si + 1);
//        if (entry_exit == "entry") {
//            tuple<string, int, string> entry = {method_name, t, "entry"};
//            call_stack.push(entry);
//        } else {
//            auto [pm_name, pt, pentry] = call_stack.top();
//            call_stack.pop();
//            if (pm_name != method_name) {
//                throw runtime_error("Unmatched method " + pm_name + ":" + method_name);
//            } else if (pentry != "entry") {
//                throw runtime_error("Method " + method_name + " has two entries");
//            } else if (pt > t) {
//                throw runtime_error("Entry time " + pt + " is later than exit time " + t);
//            }
//            tuple<string, int> call = {method_name, t - pt};
//            call_list.push_back(call);
//        }
//    }
    return call_list;
}
