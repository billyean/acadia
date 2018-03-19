package com.haiboyan.scala.algorithm.string

import org.scalatest.{FunSuite, Matchers}

class ReverseWordTest extends FunSuite with Matchers {
  test("Reverse 'My name is Tristan' should be 'Tristan is name My'") {
    assert("Tristan is name My" ===  ReverseWord.reverse("My name is Tristan"))
  }

  test("Reverse 'My name is Tristan ' should be 'Tristan is name My '") {
    assert("Tristan is name My " ===  ReverseWord.reverse("My name is Tristan "))
  }

  test("Reverse ' My name is Tristan' should be ' Tristan is name My'") {
    assert(" Tristan is name My" ===  ReverseWord.reverse(" My name is Tristan"))
  }

  test("Reverse '   My name is Tristan' should be '   Tristan is name My '") {
    assert("  Tristan is name My " ===  ReverseWord.reverse("  My name is Tristan "))
  }
}
