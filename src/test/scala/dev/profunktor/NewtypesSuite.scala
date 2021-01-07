package dev.profunktor

import munit.FunSuite
import newtypes._

class NewtypesSuite extends FunSuite {
  test("Newtypes") {
    val Foo = newType[Int]
    type Foo = Foo.Type
    println(Foo)
  }
}
