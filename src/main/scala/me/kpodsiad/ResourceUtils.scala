package me.kpodsiad

import scala.util.Using
import scala.io.Source
import scala.util.Failure
import scala.util.Success

object ResourceUtils {
  def readFromResources(name: String): Vector[String] =
    Using(Source.fromResource(name)) { source =>
      source.getLines().toVector
    }.fold(throw _, identity)
}
