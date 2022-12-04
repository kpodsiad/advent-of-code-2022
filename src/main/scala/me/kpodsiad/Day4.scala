package me.kpodsiad

private case class Range(
    start: Int,
    end: Int
) {
  def contains(other: Range): Boolean = {
    if this.start <= other.start && this.end >= other.end then true
    else false
  }

  def overlaps(other: Range): Boolean = {
    def overlapStart = this.start <= other.start && this.end >= other.start
    def overlapEnd = this.end >= other.end && this.start <= other.end
    if overlapStart || overlapEnd then true
    else false
  }
}

object Digit {
  def unapply(str: String): Option[Int] = str.toIntOption
}

object Day4 {
  private def makePairs(lines: Vector[String]): Vector[(Range, Range)] = {
    lines.map(_.split(",").flatMap(_.split("-"))).collect {
      case Array(Digit(start1), Digit(end1), Digit(start2), Digit(end2)) =>
        (Range(start1, end1), Range(start2, end2))
      case _ => sys.error("invalid input")
    }
  }

  private def solve(lines: Vector[String])(
      mappingFunction: ((Range, Range)) => Boolean
  ): Long = {
    val pairs = makePairs(lines)
    pairs
      .map(mappingFunction)
      .collect { case true =>
        1L
      }
      .sum
  }

  def solve1(lines: Vector[String]): Long = solve(lines) {
    case (first, second) =>
      first.contains(second) || second.contains(first)
  }

  def solve2(lines: Vector[String]): Long = solve(lines) {
    case (first, second) =>
      first.overlaps(second) || second.overlaps(first)
  }
}
