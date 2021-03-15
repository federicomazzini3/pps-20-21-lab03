package lab

import lab.Task1Test.{lst, lst2}
import lab.Task1.max
import lab.Task2._
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.Optionals.Option
import u02.SumTypes.{Student, Teacher}
import u03.Lists.List
import u03.Lists.List.Cons

object Task2Test {

  @Test def testMax(){
    assertEquals(Option.Some(30), max(lst));
    assertEquals(Option.Some(0), max(lst2));
    assertEquals(Option.None(), max(List.Nil()))
  }

  @Test def testGetAllCourses{
    val mario  = Student("Mario", 1998)
    val luigi = Teacher("Luigi", "Matematica")
    val silvia = Teacher("Silvia", "Italiano")

    assertEquals(Cons("Matematica", Cons("Italiano", List.Nil())), getAllCourses(List.Cons(mario, Cons(luigi, Cons(silvia, List.Nil())))))
    assertEquals(Cons("Matematica", Cons("Italiano", List.Nil())), getAllCoursesWithExternalCondition(List.Cons(mario, Cons(luigi, Cons(silvia, List.Nil())))))
    assertEquals(List.Nil(), getAllCourses(List.Cons(mario, List.Nil())))
  }
}
