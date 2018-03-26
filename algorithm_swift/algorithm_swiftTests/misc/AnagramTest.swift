//
//  AnagramTest.swift
//  algorithm_swiftTests
//
//  Created by Haibo Yan on 3/26/18.
//  Copyright © 2018 Haibo Yan. All rights reserved.
//

import XCTest
@testable import algorithm_swift

class AnagramTest: XCTestCase {
    let anagram = Anagram()
    
    override func setUp() {
        super.setUp()
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }
    
    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        super.tearDown()
    }
    
    func testSimple1() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        XCTAssertTrue(anagram.isAnagram("anagram", "nagaram"), "anagram and nagaram are anagram")
    }

    func testSimple2() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        XCTAssertFalse(anagram.isAnagram("rat", "cat"), "rat and cat are not anagram")
    }

    func testSimple3() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        XCTAssertFalse(anagram.isAnagram("eat", "eating"), "eat and eating are not anagram")
    }
    
    func testSimple4() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        XCTAssertTrue(anagram.isAnagram("cat", "cat"), "cat and cat are anagram")
    }
}
