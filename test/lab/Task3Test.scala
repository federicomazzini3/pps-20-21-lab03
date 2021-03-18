package lab

import lab.Task3._
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List
import u03.Lists.List.Cons
import u03.Streams.Stream


object Task3Test {

  /* ex 5 test */
  @Test
  def testDrop1 {
    val s = Stream.take(Stream.iterate(0)(_ + 1))(10)

    assertEquals(Stream.toList(Stream.take(Stream.iterate(6)(_ + 1))(4)), Stream.toList(Stream.drop(s)(6)))
    assertEquals(Stream.toList(Stream.empty[Int]()), Stream.toList(Stream.drop(s)(100)))
  }

  /* ex 6 test */
  @Test
  def testDropEmptyStream {
    val s = Stream.empty[Int]()
    assertEquals(Stream.toList(Stream.empty[Int]()), Stream.toList(Stream.drop(s)(6)))
  }

  /* ex 7 test */
  @Test
  def testConstant {
    var expected = Cons("x", Cons("x", Cons("x", Cons("x", Cons("x", List.Nil())))))
    var calculate = Stream.toList(Stream.take(constant("x"))(5))
    assertEquals(expected, calculate)
  }

  @Test
  def testFibonacci {
    var expected = Cons(0, Cons(1, Cons(1, Cons(2, Cons(3, Cons(5, Cons(8, Cons(13, List.Nil()))))))))
    var calculate = Stream.toList((Stream.take(fibs)(8)))
    assertEquals(expected, calculate);
  }
}
