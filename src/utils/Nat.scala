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
  
  implicit def toInt(n: Nat) = n.value
  
  
}


