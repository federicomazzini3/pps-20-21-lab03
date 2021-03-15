package lab
import u03.Lists.List.Cons
import u03.Lists._

object Lists {

def drop[A](l: List[A], n: Int): List[A] = l match {
  case Cons(h,t) if (n > 0) => drop(t, n - 1)
  case _ => l
}

}
