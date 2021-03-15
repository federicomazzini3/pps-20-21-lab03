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
}
