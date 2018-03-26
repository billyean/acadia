//
//  Anagram.swift
//  algorithm_swift
//
//  Created by Haibo Yan on 3/26/18.
//  Copyright © 2018 Haibo Yan. All rights reserved.
//

import Foundation

class Anagram {
    func isAnagram(_ s1: String, _ s2: String) -> Bool {
        let cm1 = Dictionary(grouping: Array(s1), by: {$0})
        let cm2 = Dictionary(grouping: Array(s2), by: {$0})
        
        for (k1,v1) in cm1 {
            if let v2 = cm2[k1] {
                if (v1 != v2) {
                    return false
                }
            } else {
                return false
            }
        }
        for (k2,v2) in cm2 {
            if let v1 = cm1[k2] {
                if (v2 != v1) {
                    return false
                }
            } else {
                return false
            }
        }
        
        return true
    }
}
