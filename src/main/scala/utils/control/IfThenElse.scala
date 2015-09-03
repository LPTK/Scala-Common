package utils.control

import utils._

object IfThenElse {
  
  
  def If[T] (cond: Bool)(body: => T) = if (cond) Some(body) else None
  
  implicit class ElseAble[T](val self: Option[T]) extends AnyVal {
    def Else(body: => T) = self getOrElse body
  }
  
  
  
}






