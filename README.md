# newtypes

Exploring zero-cost wrappers (aka newtypes) for Scala 3 built on top of [opaque types](https://dotty.epfl.ch/docs/reference/other-new-features/opaques.html).

```scala
import dev.profunktor.NewType

val Foo = NewType.of[Int]
type Foo = Foo.Type

def something(foo: Foo): Unit =
  println(foo.value)

something(Foo(22)) // prints out 22
something(123)     // fails to compile
```
