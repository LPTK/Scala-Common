package utils;
//package util
//
///** TODO: document */
//trait Viewable[-T,+V] {
//  def view(t: => T): V  // should return immutable view (abstraction safe if possible)
//}
//
//trait ViewerOf[T] {
//  type V
//  def view(t: => T): V
//}
//
//object Viewable {
//  implicit def AnyViewable[T <: AnyVal] = new Viewable[T,Cell[T]] {
//    def view(t: => T) = Cell.View(t)
//  }
//  implicit def StrViewable = new Viewable[String,Cell[String]] {
//    def view(t: => String) = Cell.View(t)
//  }
//  
//  // etc. for immutable values
//  
//  
//  implicit def AnyCellViewer[T <: AnyVal] = new ViewerOf[T] {
//    type V = Cell[T]
//    def view(t: => T) = Cell.View(t)
//  }
//  implicit def CellCellViewer[T] = new ViewerOf[Cell[T]] {
//    type V = Cell[T]
//    def view(t: => Cell[T]) = t.view
//  }
//  
//  
//  
////  def CellViewable[T, C <: Cell[T]] = new Viewable[C, Cell[T]] {
////    def view(t: => C) = t.view
////  }
////  def CellViewable[T] = new Viewable[Cell[T]] {
////    def view(t: Cell[T]) = t.view
////  }
//  
//  
////  trait CellViewable[T] extends Viewable[T,Cell[T]]
////  
////  def trans[T,V](x: T)(implicit T: Viewable[T,V]) = new CellViewable[T] {
////    
////  }
////  
////  implicitly[CellViewable[Int]]
//  
//  
//////  implicit class foo[T,V](val x: T)(implicit viewer: Viewable[T,V]) {
//////    def !!! = viewer.view(x)
//////  }
//////  implicit class foo[T: Numeric](val x: T) {
////  implicit class foo[T](val x: T)(implicit N: Numeric[T]) {
////    def !!! = 0
////  }
////  
////  foo(5).!!!
////  (5).!!!
//  
//  
//}
//
//
