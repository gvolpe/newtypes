package dev.profunktor

import munit.FunSuite

class NewtypesSuite extends FunSuite {
  test("Newtypes") {
    val Foo = NewType.of[Int]
    type Foo = Foo.Type

    val Bar = NewType.of[Boolean]
    type Bar = Bar.Type

    assertEquals(Foo(123), Foo(123))
    assertEquals(Foo(111).value, 111)

    assertEquals(Bar(true), Bar(true))
    assertNotEquals(Bar(true), Bar(false))
    assertEquals(Bar(true).value, true)

    compileErrors("Foo(1) == 1")
    compileErrors("Bar(true) == true")

    def bar(foo: Foo, bar: Bar): Unit =
      if (bar.value) () else println(foo)

    bar(Foo(22), Bar(true))
  }
}
