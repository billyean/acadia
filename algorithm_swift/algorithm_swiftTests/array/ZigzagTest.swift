//
//  ZigzagTest.swift
//  algorithm_swiftTests
//
//  Created by Haibo Yan on 3/25/18.
//  Copyright © 2018 Haibo Yan. All rights reserved.
//

import XCTest
@testable import algorithm_swift

class ZigzagTest: XCTestCase {
    
    override func setUp() {
        super.setUp()
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }
    
    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        super.tearDown()
    }
    
    func testExample() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        let zigzag = Zigzag()
        XCTAssertEqual(zigzag.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR")
    }
    
}
