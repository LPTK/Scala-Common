package utils.collns

class UnmodifiableView[A](coll: Seq[A]) extends collection.Seq[A]{
    def length = coll.length

    def apply(idx: Int) = coll(idx)

    def iterator = coll.iterator
}

object UnmodifiableView {
  
  implicit class UnmodifSeq[A](coll: Seq[A]) {
    def unmodifiable = new UnmodifiableView(coll)
  }
  
}

