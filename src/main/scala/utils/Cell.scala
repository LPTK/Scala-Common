package utils

import scala.language.implicitConversions

//import scala.{ specialized => sp }
import utils.{ DummyAnnot => sp }

import Cell._

trait Cell[@sp +T] {
self =>
  
  def value: T
  
  def unary_! = value
  def apply() = value // for Cell[Bool] it's less confusing
  
  def map[@sp R] (f: T => R) = new Cell[R] {
    def value = f(self.value)
  }
//  def copy = Mut(value)
//  def copy = View(value)
  
  def view = new Cell[T] {
    def value = self.value
  }
  
  def cache(implicit cache: Caching) =
    cache(value)
  
  override def toString = s"Cell($value)"
}

trait MutCell[@sp T] extends Cell[T] {
//self =>
  
  def := (v: T)
  
  // This is stupid and defetes the purpose of view:
//  override def view = MutView(value, v => :=(v))
}

object Cell {
  case class Mut[@sp T](var value: T) extends MutCell[T] {
//  case class Mut[@sp T](var value: T) extends Cell[T] with MutCell[T] {
    def := (v: T) = value = v
  }
//  def apply[T](v: => T) = new Cell[T] {
//    def value = v
//  }
  def apply[@sp T](v: T) = Mut(v) // TODO: cast to Cell so we can use tweens... (use Mut to get a Mut)
  object View {
    def apply[@sp T](v: => T) = new Cell[T] { def value = v }
  }
  def unapply[@sp T](c: Cell[T]) = Some(c.value)
  
  object MutView {
    def apply[@sp T](get: => T, set: T => Unit) = new MutCell[T] {
//    def apply[@sp T](get: => T, set: T => Unit) = new Cell[T] with MutCell[T] {
      def value = get
      def := (v: T) = set(v)
    }
  }
  
  implicit class CopyableCell[T](val c: Cell[T]) {
    def copy = View(c.value)
  }
  
  implicit def fromT[@sp T] (t: T): Cell[T] = Cell(t)
//  implicit def toT[T] (c: Cell[T]) = !c
  
//  implicit def numericCell[T: Numeric](c: Cell[T]): Numeric[Cell[T]] = new Numeric[Cell[T]] {
  implicit def numericCell[T: Numeric] = new Numeric[Cell[T]] {
//  implicit def numericCell[T: Numeric, C <: Cell[T]] = new Numeric[C] {
    val T = implicitly[Numeric[T]]
//    import T._
    type C = Cell[T]
    val C = Cell
    val CV = C.View
    import Numeric.Implicits._
    
//    val a = ??? :T
//    (mkNumericOps(a) * a)
//    (T.times(a, a))
    
    def fromInt(x: Int) = Cell[T](T fromInt x)  // Cell[T](x)
//    def fromInt(x: Int) = Cell[T](x)
    def minus(x: C, y: C): C = CV(!x - !y)
    def negate(x: C): C = CV(-(!x))
    def plus(x: C, y: C) = CV(!x + !y)
    def times(x: C, y: C) = CV(!x * !y)
    def toDouble(x: C): Double = (!x).toDouble
    def toFloat(x: C) = (!x).toFloat
    def toInt(x: C) = (!x).toInt
    def toLong(x: C): Long = (!x).toLong
    def compare(x: C, y: C) = T compare (!x, !y)
  }
  
//  implicit def floatingCell[T: FloatingPoint](c: Cell[T]) = new FloatingPoint[Cell[T]] {
  implicit def floatingCell[T: FloatingPoint] = new FloatingPoint[Cell[T]] {
    val FP: FloatingPoint[T] = implicitly[FloatingPoint[T]]
//    import FP._
    
    type C = Cell[T]
    
    def toDouble(t: C) = FP.toDouble(!t)
    def toFloat(t: C) = FP.toFloat(!t)
    implicit def fromDouble(t: Double): Cell[T] = Cell(FP fromDouble t)
  }
  
////  implicit def viewableCell[T, C <: Cell[T]] = new Viewable[C, Cell[T]] {
////    def view(t: => C) = t.view
////  }
//  implicit def viewableCell[T] = new Viewable[Cell[T], Cell[T]] {
//    def view(t: => Cell[T]) = t.view
//  }
//  
////  implicitly[Viewable[Cell[Int],_]]
//  def foo[C,V](c: C)(implicit viewer: Viewable[C,V]) = new { def lol = 0 }
//  
//  foo(Cell(42))
//  foo[Cell[Int],Cell[Int]](Cell(42))
//  
//  foo[Cell[Int],Cell[Int]](Cell(42)).lol
//  foo(Cell(42)).lol
////  (Cell(42)).lol
//  
  
  
}












