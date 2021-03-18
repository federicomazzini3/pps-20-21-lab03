package lab

import lab.Task2._
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.SumTypes.{Person, Student, Teacher}
import u03.Lists.List
import u03.Lists.List.Cons

object Task2Test {

  @Test def testGetAllCourses {
    val mario = Student("Mario", 1998)
    val luigi = Teacher("Luigi", "Matematica")
    val silvia = Teacher("Silvia", "Italiano")
    val people = List.Cons[Person](mario, Cons(luigi, Cons(silvia, List.Nil())))
    val allCourses = List.Cons("Matematica", Cons("Italiano", List.Nil()))

    assertEquals(allCourses, getAllCourses(people))
    assertEquals(allCourses, getAllCoursesWithExternalCondition(people))
    assertEquals(List.Nil(), getAllCourses(List.Cons(mario, List.Nil())))
  }

  @Test def testFoldLeft {
    val lst = Cons(3, Cons(7, Cons(1, Cons(5, List.Nil()))))
    val emptyLst = List.Nil[Int]()

    assertEquals(-16, foldLeft(lst)(0)(_ - _))
    assertEquals(0, foldLeft(emptyLst)(0)(_ - _))
  }

  @Test def testFoldRight {
    val lst = Cons(3, Cons(7, Cons(1, Cons(5, List.Nil()))))
    val emptyLst = List.Nil[Int]()

    assertEquals(-8, foldRight(lst)(0)(_ - _))
    assertEquals(0, foldRight(emptyLst)(0)(_ - _))
  }

}
