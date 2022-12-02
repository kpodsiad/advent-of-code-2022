package me.kpodsiad

class Day2Test extends munit.FunSuite {
  test("test-input") {
    val lines = ResourceUtils.readFromResources("test2.txt")
    val obtained1 = Day2.solve1(lines).sum
    val obtained2 = Day2.solve2(lines).sum

    assertEquals(
      obtained = obtained1,
      expected = 15L
    )

    assertEquals(
      obtained = obtained2,
      expected = 12L
    )
  }

  test("actual-input") {
    val lines = ResourceUtils.readFromResources("day2.txt")
    val obtained1 = Day2.solve1(lines).sum
    val obtained2 = Day2.solve2(lines).sum

    assertEquals(
      obtained = obtained1,
      expected = 8890L
    )

    assertEquals(
      obtained = obtained2,
      expected = 10238L
    )
  }
}
