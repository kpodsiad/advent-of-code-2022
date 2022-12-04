package me.kpodsiad

class Day4Test extends munit.FunSuite {
  test("test-input") {
    val lines = ResourceUtils.readFromResources("test4.txt")
    val obtained1 = Day4.solve1(lines)
    val obtained2 = Day4.solve2(lines)

    assertEquals(
      obtained = obtained1,
      expected = 2L
    )

    assertEquals(
      obtained = obtained2,
      expected = 4L
    )
  }

  test("actual-input") {
    val lines = ResourceUtils.readFromResources("day4.txt")
    val obtained1 = Day4.solve1(lines)
    val obtained2 = Day4.solve2(lines)

    assertEquals(
      obtained = obtained1,
      expected = 448L
    )

    assertEquals(
      obtained = obtained2,
      expected = 794L
    )
  }
}