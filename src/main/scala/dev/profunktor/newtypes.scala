package dev.profunktor

import scala.compiletime.erasedValue

object newtypes:
  class NewType[A]:
    opaque type Type = A
    def apply(a: A): Type = a
    extension (a: Type) def value: A = a
  end NewType

  class NewTypeBool extends NewType[Boolean]:
    override opaque type Type = Boolean
    override def apply(a: Boolean): Type = a
    extension (a: Type) override def value: Boolean = a
  end NewTypeBool

  class NewTypeInt extends NewType[Int]:
    override opaque type Type = Int
    override def apply(a: Int): Type = a
    extension (a: Type) override def value: Int = a
  end NewTypeInt

  class NewTypeLong extends NewType[Long]:
    override opaque type Type = Long
    override def apply(a: Long): Type = a
    extension (a: Type) override def value: Long = a
  end NewTypeLong

  class NewTypeString extends NewType[String]:
    override opaque type Type = String
    override def apply(a: String): Type = a
    extension (a: Type) override def value: String = a
  end NewTypeString

  transparent inline def newType[A] = inline erasedValue[A] match {
    case _: Boolean => new NewTypeBool
    case _: Int     => new NewTypeInt
    case _: Long    => new NewTypeLong
    case _: String  => new NewTypeString
    case _          => new NewType[A]
  }
end newtypes
