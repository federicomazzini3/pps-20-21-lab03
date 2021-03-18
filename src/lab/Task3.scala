package lab

import u03.Streams.Stream

object Task3 {

  def constant[A](a: A): Stream[A] = Stream.cons(a, constant(a))

  def fibs: Stream[Long] = {
    def _fib(n1: Long, n2: Long): Stream[Long] = Stream.cons(n1+n2, _fib(n2, n1+n2))
    Stream.cons(0, Stream.cons(1,_fib(0,1)))
  }

}
