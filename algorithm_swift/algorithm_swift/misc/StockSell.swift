//
//  StockSell.swift
//  algorithm_swift
//
//  Created by Haibo Yan on 3/26/18.
//  Copyright © 2018 Haibo Yan. All rights reserved.
//

import Foundation

class StockSell {
    func maxProfitI(prices: [Int]) -> Int {
        var profit = 0
        var lowest = prices[0]
        
        for i in 1..<prices.count {
            lowest = min(lowest, prices[i])
            profit = max(profit, prices[i] - lowest)
        }
        
        return profit
    }
    
    func maxProfitII(prices: [Int]) -> Int {
        var profit = 0
        for i in 1..<prices.count {
            profit += max(0, prices[i] - prices[i - 1])
        }
        
        return profit
    }
    
    func maxProfitIII(prices: [Int]) -> Int {
        var left = [Int](), right = [Int]()
        
        for _ in 0..<prices.count {
            left.append(0)
            right.append(0)
        }
        
        
        var lowest = prices[0]
        for i in 1..<prices.count {
            lowest = min(lowest, prices[i])
            left[i] = max(left[i - 1], prices[i] - lowest)
        }
        
        var highest = prices[prices.count - 1]
        for i in (0..<prices.count-1).reversed() {
            highest = max(highest, prices[i])
            right[i] = max(right[i + 1], highest - prices[i])
        }
        
        let profit = zip(left, right).map{(l: Int, r: Int) -> Int in return l + r}.max()
        
        if let profit = profit {
            return profit
        } else {
            return 0
        }
    }
    
    func maxProfitIV(prices: [Int], k: Int) -> Int {
        var profits = [[Int]]()
        var profit0 = [Int]()
        for _ in prices {
            profit0.append(0)
        }
        profits.append(profit0)

        let lk = min(k, prices.count)
        for _ in 0..<lk {
            var prev = profits.last
            var current = [Int]()
            current.append(0)
            var md = 0 - prices[0]
            for j in 1..<(prev?.count)! {
                current.append(max(current.last!, prices[j] + md))
                md = max(md, prev![j] - prices[j])
            }
            profits.append(current)
        }

        if let kl =  profits.last {
            if let profit = kl.last {
                return profit
            }
        }
        return 0
    }
}

