package me.kpodsiad

object Day3 {
  private val priorityMap: Map[Char, Long] =
    (('a' to 'z') concat ('A' to 'Z')).zip(1L to 52).toMap

  def solve1(lines: Vector[String]): Vector[Long] = {
    val priorities = lines
      .map { line =>
        val middle = line.size / 2
        val firstHalf = Set.from(line.substring(0, middle))
        val secondHalf = Set.from(line.substring(middle))
        val commonLetter = line
          .find(letter =>
            firstHalf.contains(letter) && secondHalf.contains(letter)
          )
          .fold(sys.error("wrong input"))(identity)
        priorityMap(commonLetter)
      }
    priorities
  }

  def solve2(lines: Vector[String]): Vector[Long] = {
    val priorities = lines
      .grouped(3)
      .map { lines =>
        val Vector(first, second, third) = lines.map(Set.from(_))
        val all = first union second union third
        val commonLetter = all
          .find(letter =>
            first.contains(letter) && second.contains(letter) && third
              .contains(letter)
          )
          .fold(sys.error("wrong input"))(identity)
        priorityMap(commonLetter)
      }
    priorities.toVector
  }

}
