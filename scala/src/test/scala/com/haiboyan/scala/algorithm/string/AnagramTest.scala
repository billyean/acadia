package com.haiboyan.scala.algorithm.string

import org.scalatest.{FunSuite, Matchers}

class AnagramTest extends FunSuite with Matchers {
  test("'anagram' and 'nagaram' is anagram") {
    assert(Anagram.isAnagram("anagram", "nagaram"))
  }

  test("'' and '' is anagram") {
    assert(Anagram.isAnagram("", ""))
  }

  test("'rat' and 'cat' is not anagram") {
    assert(!Anagram.isAnagram("rat", "cat"))
  }

  test("'anagram' and 'nnagaram' is not anagram") {
    assert(!Anagram.isAnagram("anagram", "nnagaram"))
  }
}
