import org.scalatest._

import utils._
import control._
import IfThenElse._
import Looping._

class Control extends FlatSpec with Matchers {
  override def convertToEqualizer[T](left: T) = ???

  "If Then Else" should "work" in {
    val (x, y) = (42, 666)
    
    assert(If (x < 666) { "ok" } == Some("ok"))
    
    assert((If (x > 666) { "ok" } Else "ko") == "ko")
    
    
  }
  
  "TailRec" should "work" in {
    
    // Nice, atrociously inefficient implementations of pow2 :)
    def pow2_ref(n: Int) = 1 +: (Stream continually 2 take n) reduce (_ * _)
    
    def pow2(n: Int) = (n,1) loop {
      case (0,r) => Ret(r)
      case (e,acc) => Rec(e-1, acc*2)
      case _ => wtf
    }
    
    assert(pow2(0) == pow2_ref(0))
    assert(pow2(1) == pow2_ref(1))
    assert(pow2(16) == pow2_ref(16))
    
    val ans = (List(1,0,1,0,1), 0) loop {
      case (Nil, acc) => Ret(acc)
      case (1 :: ls, acc) => Rec(ls, acc + pow2(ls.length+1))
      case (0 :: ls, acc) => Rec(ls, acc)
      case _ => wtf
    }
    
    assert(ans == 42)
    
  }
  
  "Looping" should "work" in {
    
    val N = 42

    {
      var i,j = 0
      
      while ({j += 1; i < N}) i+= 1
      
      assert(i === N)
      assert(j === (N+1))
    }
    
    {
      var i,j = 0

      Loop {
        j += 1
      }.While (i < N) {
        i += 1
      }

      assert(i === N)
      assert(j === (N+1))
    }
    
  }
  
  
}












