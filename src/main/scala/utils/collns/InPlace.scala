package utils
package collns

object InPlace {
  
  // TODO: specialize for different sequence types
  implicit class RichSeq[T](val self: MutSeq[T]) extends AnyVal {
    
    // TODO: in-place sorting, filtering, mapping...
    
  }
  
  
}
