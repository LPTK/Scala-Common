package object utils {
  
  type Bool = Boolean
  val Bool = Boolean
  
  type Str = String
//  val Str = String
  
  type Sym = Symbol
  val Sym = Symbol
  
  type Opt[+T] = Option[T]
  val Opt = Option
  
  type Eit[+A,+B] = Either[A,B]
  val Eit = Either
  
  
//  @inline
  def wtf = throw new Exception("Unexpected program state reached")
//  @inline
  def wth(str: => Str) = throw new Exception(s"Unexpected program state reached: str")
  
  
  implicit class Andable[T](val self: T) extends AnyVal {
    
    def and(f: T => Unit) = { f(self); self }
    
    def oh_and(f: => Unit) = { f; self }
    
//    def but_before(f: => Unit) = { f; self }
    
  }
  
  def enclose[T](before: => Unit, after: => Unit)(f: => T) =
    {before; f} oh_and after
  
  
  
}


