//
//  StockSellTest.swift
//  algorithm_swiftTests
//
//  Created by Haibo Yan on 3/26/18.
//  Copyright © 2018 Haibo Yan. All rights reserved.
//

import XCTest
@testable import algorithm_swift

class StockSellTest: XCTestCase {
    let stockSell = StockSell()
    
    override func setUp() {
        super.setUp()
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }
    
    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        super.tearDown()
    }
    
    func testProfitI1() {
        let prices = [7, 1, 5, 3, 6, 4, 5]
        XCTAssertEqual(stockSell.maxProfitI(prices: prices), 5)
    }

    func testProfitI2() {
        let prices = [7, 6, 4, 3, 2, 1]
        XCTAssertEqual(stockSell.maxProfitI(prices: prices), 0)
    }
    
    func testProfitII1() {
        let prices = [7, 1, 5, 3, 6, 4, 5]
        XCTAssertEqual(stockSell.maxProfitII(prices: prices), 8)
    }
    
    func testProfitII2() {
        let prices = [7, 6, 4, 3, 2, 1]
        XCTAssertEqual(stockSell.maxProfitII(prices: prices), 0)
    }
    
    func testProfitIII1() {
        let prices = [7, 1, 5, 3, 6, 4, 5]
        XCTAssertEqual(stockSell.maxProfitIII(prices: prices), 7)
    }
    
    func testProfitIII2() {
        let prices = [7, 6, 4, 3, 2, 1]
        XCTAssertEqual(stockSell.maxProfitIII(prices: prices), 0)
    }
    
    func testProfitIV1() {
        let prices = [7, 1, 5, 3, 6, 4, 5]
        XCTAssertEqual(stockSell.maxProfitIV(prices: prices, k: 1), 5)
    }
    
    func testProfitIV2() {
        let prices = [7, 1, 5, 3, 6, 4, 5]
        XCTAssertEqual(stockSell.maxProfitIV(prices: prices, k: 2), 7)
    }
    
    func testProfitIV3() {
        let prices = [7, 1, 5, 3, 6, 4, 5]
        XCTAssertEqual(stockSell.maxProfitIV(prices: prices, k: 3), 8)
    }
    
    func testProfitIV4() {
        let prices = [7, 1, 5, 3, 6, 4, 5]
        XCTAssertEqual(stockSell.maxProfitIV(prices: prices, k: 4), 8)
    }

    func testProfitIV5() {
        let prices = [7, 1, 5, 3, 6, 4, 5]
        XCTAssertEqual(stockSell.maxProfitIV(prices: prices, k: 0), 0)
    }
    
    func testProfitIV6() {
        let prices = [7, 6, 5, 4, 3, 2, 1]
        XCTAssertEqual(stockSell.maxProfitIV(prices: prices, k: 1), 0)
    }
    
    func testProfitIV7() {
        let prices = [1, 2, 3, 4, 5, 6, 7]
        XCTAssertEqual(stockSell.maxProfitIV(prices: prices, k: 100), 6)
    }
}
