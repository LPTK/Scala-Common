package utils

class RecVal[T](expr: RecVal[T] => T) {
  val value = expr(this)
  def get = value
}

object RecVal {
  def apply[T](e: RecVal[T] => T): RecVal[T] = new RecVal[T](e)
}



