package lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import lab.Lists._
import u03.Lists.List
import u03.Lists.List.Cons

object ListTest {

  val lst = List.Cons(10, Cons(20, Cons(30,List.Nil())))

  @Test def testDrop(){
    assertEquals(Cons(20,Cons(30,List.Nil())), drop(lst, 1))
    assertEquals(Cons(30,List.Nil()), drop(lst, 2))
    assertEquals(List.Nil(), drop(lst, 5))
  }

  @Test def testNegativeDrop() {
    assertEquals(lst, drop(lst, -1))
  }

  @Test def testFlatMap() {
    assertEquals(Cons(11,Cons(21,Cons(31,List.Nil()))), flatMap(lst)(v => Cons(v + 1 , List.Nil())))
    assertEquals(Cons(11,Cons(21,Cons(31,List.Nil()))), flatMap(lst)(v => Cons(v+1, Cons(v+2, List.Nil()))))
  }

}
