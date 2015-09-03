package utils.control

import utils._

object Looping {
  
  // TODO: lightweight non-tailrec loops (that don't overflow)
  
  sealed trait Cmd[+T,+R]
  case class Ret[+T,+R](value: R) extends Cmd[T,R]
  case class Rec[+T,+R](expr: T) extends Cmd[T,R]
//  case class Defer[+T,+R](expr: T, fun: R => R) extends Cmd[T,R]
  
  implicit class TailRec[T](val self: T) extends AnyVal {
    def loop[R](f: T => Cmd[T,R]): R = {
      var cmd: Cmd[T,R] = Rec(self)
      var deferred: Option[R => R] = None
      while (true) cmd match {
        case Ret(r) => return r
        case Rec(v) => cmd = f(v)
//        case Defer(v, df) =>
//          deferred foreach {of => require(of === df, "Can only use one deferred function (c.f.: tail recursivity)")}
//          if (deferred.isEmpty) deferred = Some(df)
//          cmd = f(v)
      }
      wtf
    }
  }
  
  //
  
  def Loop(pre: => Unit) = new {
    def While(cond: => Bool)(body: => Unit) = {
      while ({pre; cond}) body
    }
  }
  
  
}









