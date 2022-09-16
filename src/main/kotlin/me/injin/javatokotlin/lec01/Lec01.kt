package me.injin.javatokotlin.lec01

class Lec01

fun main() {
    var number1 = 10L
    val number2 = 10L

    var number3: Long
    val number4: Long

    //코틀린은 박싱, 언박싱을 신경쓰지 않아도 된다. 코틀린이 적절하게 처리해 준다.

    var number5: Long?
    number5 = null

    var person = Person("인진")
}

class Person(name: String)
