package me.injin.javatokotlin.chapter02

class Lec08

fun main() {
    //함수 선언 문법

    //default parameter
    repeat("hello kotlin !!!")
    //named argument (parameter)
    repeat("hello kotlin !!!", useNewLine = false)
    println("===")
    //같은 타입의 여러 파라미터 받기 (가변인자)
    printAll("a", "b", "c")
    val array = arrayOf("d", "e", "f")
    printAll(*array)
}

fun max1(a: Int, b: Int): Int {
    return if(a >  b) a
    else b
}

fun max2(a: Int, b: Int): Int =
    if(a >  b) a
    else b

fun max3(a: Int, b: Int) = if(a >  b) a else b


fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            println(str)
        }
    }
}

fun printAll(vararg str: String) {
    for (s in str) {
        println(s)
    }
}

