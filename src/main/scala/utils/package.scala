package object utils {
  
  // Useful Type Synonyms
  
  type Bool = Boolean
  val Bool = Boolean
  
  type Str = String
  
  type Sym = Symbol
  val Sym = Symbol
  
  type Opt[+T] = Option[T]
  val Opt = Option
  
  type Eit[+A,+B] = Either[A,B]
  val Eit = Either
  
  import collection._
  
  type ImSeq[+A] = immutable.Seq[A]
  val ImSeq = immutable.Seq
  type MutSeq[A] = mutable.Seq[A]
  val MutSeq = mutable.Seq
  
  type ImSet[A] = immutable.Set[A]
  val ImSet = immutable.Set
  type MutSet[A] = mutable.Set[A]
  val MutSet = mutable.Set
  
  type ImMap[A, +B] = immutable.Map[A,B]
  val ImMap = immutable.Map
  type MutMap[A, B] = mutable.Map[A,B]
  val MutMap = mutable.Map
  
  
  
  
  // Other
  
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
  
  
  implicit class SafeEq[T](val self: T) extends AnyVal {
    def ===(that: T) = self == that
  }
  
  
}











