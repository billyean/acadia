//
//  RomeDigits.swift
//  algorithm_swift
//
//  Created by Haibo Yan on 3/26/18.
//  Copyright © 2018 Haibo Yan. All rights reserved.
//

import Foundation

class RomeDigits {
    let rtoi: [Character: Int] = ["I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000]
    
    let boundary = [(1000, 900, "M", "C"),
                    ( 500, 400, "D", "C"),
                    ( 100,  90, "C", "X"),
                    (  50,  40, "L", "X"),
                    (  10,   9, "X", "I"),
                    (   5,   4, "V", "I"),
                    (   1,   1, "I", "I")]
    
    func toRome(_ integer: Int) -> String {
        var n = integer
        var rome = ""
        
        for (up, low, charUp, charLow) in boundary {
            while n >= low {
                if n < up {
                    rome += charLow
                }
                rome += charUp
                n -= up
                if n < 0 {
                    n += up - low
                }
            }
        }
        
        return rome
    }
    
    func toInteger(_ rome:String) -> Int {
        var r = 0
        
        for i in 0..<rome.count {
            let c = rome[i]
            if let v = rtoi[c] {
                if i < rome.count - 1 && v < (rtoi[rome[i + 1]])! {
                    r -= v
                } else {
                    r += v
                }
            }
        }
        
        return r
    }
}

extension String {
    subscript (i: Int) -> Character {
        return self[index(startIndex, offsetBy: i)]
    }
    subscript (bounds: CountableRange<Int>) -> Substring {
        let start = index(startIndex, offsetBy: bounds.lowerBound)
        let end = index(startIndex, offsetBy: bounds.upperBound)
        return self[start ..< end]
    }
    subscript (bounds: CountableClosedRange<Int>) -> Substring {
        let start = index(startIndex, offsetBy: bounds.lowerBound)
        let end = index(startIndex, offsetBy: bounds.upperBound)
        return self[start ... end]
    }
    subscript (bounds: CountablePartialRangeFrom<Int>) -> Substring {
        let start = index(startIndex, offsetBy: bounds.lowerBound)
        let end = index(endIndex, offsetBy: -1)
        return self[start ... end]
    }
    subscript (bounds: PartialRangeThrough<Int>) -> Substring {
        let end = index(startIndex, offsetBy: bounds.upperBound)
        return self[startIndex ... end]
    }
    subscript (bounds: PartialRangeUpTo<Int>) -> Substring {
        let end = index(startIndex, offsetBy: bounds.upperBound)
        return self[startIndex ..< end]
    }
}
