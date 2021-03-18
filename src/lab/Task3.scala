package lab

import u03.Streams.Stream

object Task3 {

  /*
  ex 5
  go to method implementation called drop inside Streams object
   */
  def drop[A](stream: Stream[A])(n:Int): Stream[A] = Stream.drop(stream)(n)

  /*
   ex 6
   */
  def constant[A](a: A): Stream[A] = Stream.iterate(a)(a => a)

  /*
  ex 7
   */
  def fibs: Stream[Long] = {
    def _fib(n1: Long, n2: Long): Stream[Long] = Stream.cons(n1, _fib(n2, n1+n2))
    _fib(0,1)
  }

}
