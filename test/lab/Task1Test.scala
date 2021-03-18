package lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import lab.Task1._
import u02.Optionals.Option
import u03.Lists.List
import u03.Lists.List.Cons

object Task1Test {

  val lst = List.Cons(10, Cons(20, Cons(30, List.Nil())))
  val lst2 = List.Cons(-10, Cons(-40, Cons(0, List.Nil())))

  /* ex 1.a test */
  @Test def testDrop() {
    assertEquals(Cons(20, Cons(30, List.Nil())), drop(lst, 1))
    assertEquals(Cons(30, List.Nil()), drop(lst, 2))
    assertEquals(List.Nil(), drop(lst, 5))
  }

  @Test def testNegativeDrop() {
    assertEquals(lst, drop(lst, -1))
  }

  /* ex 1.b test */
  @Test def testFlatMap() {
    val lstExpected1 = Cons(11, Cons(21, Cons(31, List.Nil())))
    val lstExpected2 = Cons(11, Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, List.Nil()))))))

    assertEquals(lstExpected1, flatMap(lst)(v => Cons(v + 1, List.Nil())))
    assertEquals(lstExpected2, flatMap(lst)(v => Cons(v + 1, Cons(v + 2, List.Nil()))))
  }

  /* ex 1.c test */
  @Test def testMap() {
    val lstExpected = Cons(11, Cons(21, Cons(31, List.Nil())))

    assertEquals(lstExpected, map(lst)(_ + 1))
  }

  /* ex 1.d test */
  @Test def testFilter() {
    val lstExpected = Cons(10, Cons(20, List.Nil()))
    assertEquals(lstExpected, filter(lst)(_ < 30))
  }

  /* ex 2 */
  @Test def testMax() {
    assertEquals(Option.Some(30), max(lst));
    assertEquals(Option.Some(0), max(lst2));
    assertEquals(Option.None(), max(List.Nil()))
  }
}
