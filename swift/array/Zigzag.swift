//
//  Zigzag.swift
//  Algorithm
//
//  Created by Haibo Yan on 3/12/18.
//  Copyright © 2018 Haibo Yan. All rights reserved.
//

import Foundation

public class Zigzag {
    func convert(_ s: String, _ numRows: Int) -> String {
        if (numRows < 2 || s.count == 0) {
            return s
        }
        var zs = ""
        let cs = s.map{String($0)}
        
        for i in 0...numRows-1 {
            let span1 = 2 * (numRows - i - 1)
            let span2 = 2 * i
            
            var add = true

            var b = i
            
            while b < s.count {
                zs += cs[b]
            
                switch (span1, span2, add) {
                case (0, _, _):
                    b += span2
                case (_, 0, _),
                     (_, _, true):
                    b += span1
                default:
                    b += span2
                }
                
                add = !add
            }
        }
        
        return zs
    }
}
