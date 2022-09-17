package me.injin.javatokotlin.chapter04

import me.injin.javatokotlin.etc.Person

class Lec16

fun main() {
    //확장함수 - 멤버 함수 처럼 사용할 수 있다.
    //자바 코드가 있는 상황에서 코틀린 코드로 추가 기능 개발을 하기위해 확장함수 와 확장프로퍼티가 등장했다.
    //확장함수는 클래스에 있는 private, protected 멤버를 가져올 수 없다.
    println("abcdefghijklmnopqrstuvwxyz".lastChar())
    val text = "abc"
    println(text.lastChar())
        //멤버함수와 확장함수의 시그니처가 같다면? -> 멤버함수가 우선적으로 호출된다.
    val person = Person("injin", 10)
    println(person.nextYearAge())

    //infix 함수
    println(2.add(3))
    println(5 add2 4)

    //inline 함수
    //함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로복붙하고 싶은 경우.
        //사용하면 좋은점: 함수를 파라미터로 전달할 때에 오버헤드를 줄일 수 있다.
        //하지만 inline 함수의 사용은 성능 측정과 함께 신중하게 사용되어야 한다.

    //지역 함수
    //함수 안에 함수를 선언할 수 있다. => 코드가 깔끔한것도 별로없고, 다른 좋은방법이 있으니, 사용은 안할듯 하다.

}

//확장함수
fun String.lastChar(): Char {
    return this[this.length - 1]
}

fun Person.nextYearAge(): Int {
    return this.age + 1
}

//중위함수
fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}