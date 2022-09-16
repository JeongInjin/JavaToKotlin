package me.injin.javatokotlin.chapter02

class Lec06

fun main() {
    val numbers = listOf(1, 2, 3)
    for (number in numbers) {
        println(number)
    }
    println("===")
    for (i in 1..3) {
        println(i)
    }
    println("===")
    for (i in 3 downTo 1) {
        println(i)
    }
    println("===")
    for (i in 1..5 step 2) {
        println(i)
    }
    /*
    ..연산자: 범위를 만들어 내는 연산자
    1..3 -> 1 부터 3의 범위 -> 범위는 Range 라는 실제 클래스가 있다. (IntRange -> IntProgression)
    등사수열 - 1.시작 값, 2.끝 값, 3.공차 가 필요함
    해당 1..3 은 이 코드가 등차수열을 만들어 주고 있는 코드임.
    step, downTo 같은건 중위 호출 함수 임

    */

}