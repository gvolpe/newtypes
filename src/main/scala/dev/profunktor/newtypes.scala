package dev.profunktor

import scala.compiletime.erasedValue

object NewType:
  class GenNewType[A]:
    opaque type Type = A
    def apply(a: A): Type = a
    extension (a: Type) def value: A = a
    given (using CanEqual[A, A]): CanEqual[Type, Type] = CanEqual.derived
  end GenNewType

  class NewTypeBool extends GenNewType[Boolean]:
    override opaque type Type = Boolean
    override def apply(a: Boolean): Type = a
    extension (a: Type) override def value: Boolean = a
  end NewTypeBool

  class NewTypeByte extends GenNewType[Byte]:
    override opaque type Type = Byte
    override def apply(a: Byte): Type = a
    extension (a: Type) override def value: Byte = a
  end NewTypeByte

  class NewTypeChar extends GenNewType[Char]:
    override opaque type Type = Char
    override def apply(a: Char): Type = a
    extension (a: Type) override def value: Char = a
  end NewTypeChar

  class NewTypeDouble extends GenNewType[Double]:
    override opaque type Type = Double
    override def apply(a: Double): Type = a
    extension (a: Type) override def value: Double = a
  end NewTypeDouble

  class NewTypeFloat extends GenNewType[Float]:
    override opaque type Type = Float
    override def apply(a: Float): Type = a
    extension (a: Type) override def value: Float = a
  end NewTypeFloat

  class NewTypeInt extends GenNewType[Int]:
    override opaque type Type = Int
    override def apply(a: Int): Type = a
    extension (a: Type) override def value: Int = a
  end NewTypeInt

  class NewTypeLong extends GenNewType[Long]:
    override opaque type Type = Long
    override def apply(a: Long): Type = a
    extension (a: Type) override def value: Long = a
  end NewTypeLong

  class NewTypeShort extends GenNewType[Short]:
    override opaque type Type = Short
    override def apply(a: Short): Type = a
    extension (a: Type) override def value: Short = a
  end NewTypeShort

  class NewTypeString extends GenNewType[String]:
    override opaque type Type = String
    override def apply(a: String): Type = a
    extension (a: Type) override def value: String = a
  end NewTypeString

  transparent inline def of[A] = inline erasedValue[A] match {
    case _: Boolean => new NewTypeBool
    case _: Byte    => new NewTypeByte
    case _: Char    => new NewTypeChar
    case _: Double  => new NewTypeDouble
    case _: Float   => new NewTypeFloat
    case _: Int     => new NewTypeInt
    case _: Long    => new NewTypeLong
    case _: Short   => new NewTypeShort
    case _: String  => new NewTypeString
    case _          => new GenNewType[A]
  }

end NewType
