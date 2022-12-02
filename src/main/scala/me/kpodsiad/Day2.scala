package me.kpodsiad

import me.kpodsiad.Figure.Scissors

private sealed trait Figure(val score: Long) {
  import Figure.*

  def winsOver: Figure
  def losesTo: Figure

  def play(other: Figure): Outcome = {
    if this == other then Outcome.Draw
    else if this.winsOver == other then Outcome.Win
    else Outcome.Loss
  }
}

private object Figure {
  enum Outcome(val score: Long):
    case Loss extends Outcome(0)
    case Draw extends Outcome(3)
    case Win extends Outcome(6)

  case object Rock extends Figure(1):
    override def winsOver: Figure = Scissors
    override def losesTo: Figure = Paper

  case object Paper extends Figure(2):
    override def winsOver: Figure = Rock
    override def losesTo: Figure = Scissors

  case object Scissors extends Figure(3):
    override def winsOver: Figure = Paper
    override def losesTo: Figure = Rock

  case object OpponentFigure:
    def unapply(str: String): Option[Figure] =
      if str == "A" then Some(Rock)
      else if str == "B" then Some(Paper)
      else if str == "C" then Some(Scissors)
      else None

  case object PlayerFigure:
    def unapply(str: String): Option[Figure] =
      if str == "X" then Some(Rock)
      else if str == "Y" then Some(Paper)
      else if str == "Z" then Some(Scissors)
      else None

  case object DesiredOutcome:
    def unapply(str: String): Option[Outcome] =
      if str == "X" then Some(Outcome.Loss)
      else if str == "Y" then Some(Outcome.Draw)
      else if str == "Z" then Some(Outcome.Win)
      else None
}

private final case class Round(opponentMove: Figure, playerMove: Figure):
  def score: Long = playerMove.play(opponentMove).score + playerMove.score

object Day2 {
  import Figure.*

  def solve1(lines: Vector[String]): Vector[Long] = {
    val rounds = lines
      .map { line =>
        line.split(" ") match
          case Array(OpponentFigure(opponent), PlayerFigure(player)) =>
            Round(opponent, player)
          case _ => sys.error("unexpected input")
      }
      .map(_.score)
    rounds
  }

  def solve2(lines: Vector[String]): Vector[Long] = {
    val rounds = lines
      .map { line =>
        line.split(" ") match
          case Array(OpponentFigure(opponent), DesiredOutcome(outcome)) =>
            val playerFigure = outcome match
              case Outcome.Loss => opponent.winsOver
              case Outcome.Draw => opponent
              case Outcome.Win  => opponent.losesTo
            Round(opponent, playerFigure)
          case _ => sys.error("unexpected input")
      }
      .map(_.score)
    rounds
  }
}
