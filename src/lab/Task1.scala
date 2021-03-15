package lab

import u03.Lists.List.{Cons, Nil, append}
import u03.Lists._
import u02.Optionals._

object Task1 {

  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Cons(_, t) if (n > 0) => drop(t, n - 1)
    case _ => l
  }

  def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = l match {
    case Cons(h, t) => append(f(h), flatMap(t)(f))
    case List.Nil() => List.Nil()
  }

  def map[A, B](l: List[A])(mapper: A => B): List[B] = flatMap(l)(a => Cons(mapper(a), List.Nil()))

  def filter[A](l: List[A])(pred: A => Boolean): List[A] = flatMap(l) {
    case h if pred(h) => Cons(h,Nil())
    case _ => List.Nil()
  }

  def max(l:List[Int]): Option[Int] = {
    @annotation.tailrec
    def _max(l:List[Int], n:Int): Option[Int] = l match{
      case Cons(h,t) if(h > n) => _max(t, h)
      case Cons(h,t) => _max(t, n)
      case _ => Option.Some(n)
    }
    l match {
      case Cons(h,t) => _max(t, h)
      case _ => Option.None()
    }
  }
}
