package me.kpodsiad

private case class State(
    results: List[Long],
    current: Long
)

object Day1 extends App {
  def solve(input: Vector[String]): List[Long] = {
    val calories = input.foldLeft(State(Nil, 0)) {
      case (State(acc, calories), line) =>
        line match
          case "" =>
            State(calories :: acc, 0)
          case line =>
            line.toLongOption match
              case None => sys.error("invalid input")
              case Some(food) =>
                State(acc, calories + food)
    }
    calories.results.sorted.reverse
  }

  val calories = solve(ResourceUtils.readFromResources("day1.txt"))
  val result1 = calories.head
  val result2 = calories.take(3).sum
  pprint.log(result1)
  pprint.log(result2)
}
