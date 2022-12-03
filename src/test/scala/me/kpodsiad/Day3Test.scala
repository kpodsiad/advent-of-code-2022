package me.kpodsiad

class Day3Test extends munit.FunSuite {
  test("test-input") {
    val lines = ResourceUtils.readFromResources("test3.txt")
    val obtained1 = Day3.solve1(lines).sum
    val obtained2 = Day3.solve2(lines).sum

    assertEquals(
      obtained = obtained1,
      expected = 157L
    )

    assertEquals(
      obtained = obtained2,
      expected = 70L
    )
  }

  test("actual-input") {
    val lines = ResourceUtils.readFromResources("day3.txt")
    val obtained1 = Day3.solve1(lines).sum
    val obtained2 = Day3.solve2(lines).sum

    assertEquals(
      obtained = obtained1,
      expected = 7817L
    )

    assertEquals(
      obtained = obtained2,
      expected = 2444L
    )
  }
}
