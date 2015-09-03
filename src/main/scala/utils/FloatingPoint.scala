package utils

trait FloatingPoint[T] {
  def toDouble(t: T): Double
  def toFloat(t: T): Float
  implicit def fromDouble(t: Double): T
}

object FloatingPoint {
  
  implicit object DoubleFP extends FloatingPoint[Double] {
    def toDouble(t: Double) = t
    def toFloat(t: Double) = t.toFloat
    def fromDouble(t: Double) = t
//    def fromFloat(t: Double) = t.toFloat
  }
  
  implicit object FloatFP extends FloatingPoint[Float] {
    def toDouble(t: Float) = t
    def toFloat(t: Float) = t
    def fromDouble(t: Double) = t.toFloat
  }
  
//  implicit def fromDouble[N: FloatingPoint](t: Double) =
//    implicitly[FloatingPoint[N]].fromDouble(t)
  
}


////trait FloatingPoint[T] extends Numeric[T] {
//trait FloatingPoint[T] {
//self: Numeric[T] =>
//  def toDouble(t: T): Double
//  def toFloat(t: T): Float
//  implicit def fromDouble(t: Double): T
//}
//
//object FloatingPoint {
//  
////  implicit object DoubleFP extends FloatingPoint[Double] with implicitly[Numeric[Double]] {
////  implicit object DoubleFP extends FloatingPoint[Double] {
//  implicit def DoubleFP[D >: Double <: Double: Numeric] = new FloatingPoint[Double] {
//    def toDouble(t: Double) = t
//    def toFloat(t: Double) = t.toFloat
//    def fromDouble(t: Double) = t
////    def fromFloat(t: Double) = t.toFloat
//  }
//  
//  implicit object FloatFP extends FloatingPoint[Float] {
//    def toDouble(t: Float) = t
//    def toFloat(t: Float) = t
//    def fromDouble(t: Double) = t.toFloat
//  }
//  
////  implicit def fromDouble[N: FloatingPoint](t: Double) =
////    implicitly[FloatingPoint[N]].fromDouble(t)
//  
//}




