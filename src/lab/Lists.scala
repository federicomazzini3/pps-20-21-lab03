package lab
import u03.Lists.List.{Cons, append}
import u03.Lists._

object Lists {

def drop[A](l: List[A], n: Int): List[A] = l match {
  case Cons(_,t) if (n > 0) => drop(t, n - 1)
  case _ => l
}

  def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = l match {
    case Cons(h, t) => append(f(h), flatMap(t)(f))
    case List.Nil() => List.Nil()
  }



}
