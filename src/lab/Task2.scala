package lab

import lab.Task1.{filter, flatMap}
import u02.SumTypes.{Person, Teacher}
import u03.Lists.List
import u03.Lists.List.Cons

object Task2 {


  /*implementation without external function*/
  def getAllCourses(personList: List[Person]): List[String] = flatMap(filter(personList)(_ match {
    case Teacher(_, _) => true
    case _ => false
  }))(_ match {
    case Teacher(_,c) => Cons(c, List.Nil())
  })


  def onlyCourseFromTeacherCondition(p: Person): List[String] = p match{
    case Teacher(_,c) => Cons(c, List.Nil())
  }

  def onlyTeacherCondition(person: Person): Boolean = person match {
    case Teacher(name,course) => true
    case _ => false
  }

  /* Implementation with external condition */
  def getAllCoursesWithExternalCondition(personList: List[Person]): List[String] = flatMap(filter(personList)(onlyTeacherCondition))(onlyCourseFromTeacherCondition)


}
