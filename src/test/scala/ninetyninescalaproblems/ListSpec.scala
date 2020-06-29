package ninetyninescalaproblems

import java.util.NoSuchElementException

import org.scalatest.FunSpec

class ListSpec extends FunSpec {

  describe("last") {
    it("Should return an exception when input is an empty list") {
      assertThrows[NoSuchElementException](
        new Lists().last(List())

      )
    }
    it("Should return first element of list if length is 1") {
      assert(
        new Lists().last(List(1)) == 1
      )
    }
    it("Should return last element of list when length is greater than one") {
      assert(
        new Lists().last(List(1, 2, 3, 4)) == 4
      )
    }
  }
  describe("penultimate") {
    it("Should return an exception when input is an empty list") {
      assertThrows[NoSuchElementException](
        new Lists().penultimate(List())

      )
    }
    it("Should return an exception when input is a list less than 2") {
      assertThrows[NoSuchElementException](
        new Lists().penultimate(List(1))
      )
    }
    it("Should return second to last element of list when length is greater than 2") {
      assert(
        new Lists().penultimate(List(1, 2, 3, 4)) == 3
      )
    }
  }

  describe("nth") {
    it("Should return an exception when input is an empty list") {
      assertThrows[NoSuchElementException](
        new Lists().nth(List(),0)

      )
    }
    it("Should return an exception when input n input is greater than length of list") {
      assertThrows[IndexOutOfBoundsException](
        new Lists().nth(List(1,2,3,4), 13)
      )
    }
    it("Should return nth element of list when index provided is less than or equal to length of list") {
      assert(
        new Lists().nth(List(1, 2, 3, 4), 2) == 3
      )
    }
  }


}

