package utils

import collection.mutable._

object MutCollUtils {
  
  implicit class RichSeq[T](val self: Buffer[T]) extends AnyVal {
    import self._
    def prune (pred: T => Bool) = {
      var (i, shift) = (0, 0)
      while(i < size - shift) {
        if (!pred(self(i))) i += 1
        else {
          shift += 1
          if (i+shift < size) self(i) = self(i+shift)
        }
      }
      trimEnd(shift)
    }
  }
  
  
}

object MutCollUtilsTest extends App {
  import MutCollUtils._
  
  val s = Buffer(1,0,0,1,1,1,0)
  s prune (_ == 1)
  println(s == Seq(1,1,1,1))
  
  println({val s = Buffer(0); s prune (_ == 1); s} == Seq())
  
}





