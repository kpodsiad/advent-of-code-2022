package me.kpodsiad

import munit.FunSuite

class Day1Test extends FunSuite {
  test("day1-test") {
    val obtained = Day1.solve(
      ResourceUtils.readFromResources("test1.txt")
    )
    assertEquals(
      obtained = obtained.head,
      expected = 24000L
    )
  }

    test("day1-input") {
    val obtained = Day1.solve(
      ResourceUtils.readFromResources("day1.txt")
    )
    assertEquals(
      obtained = obtained.head,
      expected = 71023L
    )
  }
}
