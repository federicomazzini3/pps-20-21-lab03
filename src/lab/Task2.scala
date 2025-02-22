package lab

import lab.Task1.{filter, flatMap}
import u02.SumTypes.{Person, Teacher}
import u03.Lists.List
import u03.Lists.List.Cons

object Task2 {

  /* ex 3 */

  // implementation without external function
  def getAllCourses(personList: List[Person]): List[String] = flatMap(filter(personList)(_ match {
    case Teacher(_, _) => true
    case _ => false
  }))(_ match {
    case Teacher(_, c) => Cons(c, List.Nil())
  })

  /* ex 3 variant A */
  def onlyCourseFromTeacher(p: Person): List[String] = p match {
    case Teacher(_, c) => Cons(c, List.Nil())
  }

  def onlyTeacher(person: Person): Boolean = person match {
    case Teacher(_, _) => true
    case _ => false
  }

  def getAllCoursesWithExternalCondition(personList: List[Person]): List[String] = {
    flatMap(filter(personList)(onlyTeacher))(onlyCourseFromTeacher)
  }

  /* ex 3 variant B */
  def getAllCoursesWithInputCondition(personList: List[Person])(peopleCondition: Person => Boolean)(parameterCondition: Person => List[String]): List[String] = {
    flatMap(filter(personList)(peopleCondition))(parameterCondition)
  }

  /* ex 4 */

  def foldLeft[E,B](list: List[E])(value: B)(f:(B, E) => B): B = list match {
    case Cons(h, t) => foldLeft(t)(f(value,h))(f)
    case List.Nil() => value
  }

  def foldRight[E,B](list: List[E])(value: B)(f:(E, B) => B): B = list match {
    case Cons(h, t) => f(h, foldRight(t)(value)(f))
    case List.Nil() => value
  }

}
