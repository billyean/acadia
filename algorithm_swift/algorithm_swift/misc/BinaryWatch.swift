//
//  BinaryWatch.swift
//  algorithm_swift
//
//  Created by Haibo Yan on 3/25/18.
//  Copyright © 2018 Haibo Yan. All rights reserved.
//

import Foundation

class BinaryWatch {
    var cache : [Int: [String]]!
    
    init() {
        cache = [:]
        for h in 0..<12 {
            for m in 0..<60 {
                let b = self.bits(h, m)
                let s = self.time(h, m)
                
                if let oldvalue = cache[b] {
                    let newValue = oldvalue + [s]
                    cache[b] = newValue
                } else {
                    cache[b] = [s]
                }
            }
        }
    }
    
    func get_n(_ n: Int) -> [String]? {
        return cache?[n]
    }
    
    func bits(_ h: Int, _ m: Int) -> Int {
        var b = 0
        var vh = h
        var vm = m
        
        while (vh > 0) {
            b += 1
            vh -= vh & -vh
        }
        
        while (vm > 0) {
            b += 1
            vm -= vm & -vm
        }
        
        return b
    }
    
    func time(_ h: Int, _ m: Int) -> String {
        return String(format: "%d:%02d", h, m)
    }
}
