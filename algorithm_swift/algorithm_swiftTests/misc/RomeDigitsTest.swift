//
//  RomeDigitsTest.swift
//  algorithm_swiftTests
//
//  Created by Haibo Yan on 3/26/18.
//  Copyright © 2018 Haibo Yan. All rights reserved.
//

import XCTest
@testable import algorithm_swift

class RomeDigitsTest: XCTestCase {
    let test_data = [1: "I",
                     2: "II",
                     3: "III",
                     4: "IV",
                     5: "V",
                     6: "VI",
                     7: "VII",
                     8: "VIII",
                     9: "IX",
                     10:"X",
                     11:"XI",
                     12:"XII",
                     13:"XIII",
                     14:"XIV",
                     15:"XV",
                     16:"XVI",
                     17:"XVII",
                     18:"XVIII",
                     19:"XIX",
                     20:"XX",
                     21:"XXI",
                     22:"XXII",
                     23:"XXIII",
                     24:"XXIV",
                     25:"XXV",
                     26:"XXVI",
                     27:"XXVII",
                     28:"XXVIII",
                     29:"XXIX",
                     30:"XXX",
                     49:"XLIX",
                     50:"L",
                     51:"LI",
                     59:"LIX",
                     60:"LX",
                     61:"LXI",
                     69:"LXIX",
                     70:"LXX",
                     71:"LXXI",
                     3499: "MMMCDXCIX"
    ]
    
    override func setUp() {
        super.setUp()
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }
    
    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        super.tearDown()
    }
    
    func testToRome() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        let rd = RomeDigits()

        for (intv, rome) in test_data {
            XCTAssertEqual(rome, rd.toRome(intv))
        }
    }
    
    func testToInt() {
        let rd = RomeDigits()

        for (intv, rome) in test_data {
            XCTAssertEqual(intv, rd.toInteger(rome))
        }
    }
}
