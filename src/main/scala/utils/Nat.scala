package utils

case class Nat(value: Int) {
  require(value >= 0)
  
  def + (n: Int) = Nat(value + n)
  def - (n: Int) = Nat(value - n)
  def * (n: Int) = Nat(value * n)
  def / (n: Int) = Nat(value / n)
  def % (n: Int) = Nat(value % n)
  
}

object Nat {
  import scala.language.implicitConversions
  
  implicit def toInt(n: Nat): Int = n.value
  
}


