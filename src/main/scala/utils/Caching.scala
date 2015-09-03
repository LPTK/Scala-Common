package utils

trait Caching {
  def apply[T](t: => T): Cell[T]
}


