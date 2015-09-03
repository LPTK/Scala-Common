package utils

class Rec[T](expr: Rec[T] => T) {
  val value = expr(this)
  def get = value
}

object Rec {
  def apply[T](e: Rec[T] => T): Rec[T] = new Rec[T](e)
}



