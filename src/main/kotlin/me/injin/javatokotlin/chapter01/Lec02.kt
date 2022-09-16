package me.injin.javatokotlin.chapter01

class Lec02

fun main() {
    //코틀린에서 널 체크
    //안전한 호출과 엘비스 연산자
    var str1: String? = "asasdf"
    println(str1?.length)

    var str2: String? = null
    println(str2?.length ?: 0)

    //널 아님 단언
    //플랙폼 타입

}

fun startWithA1(str: String?): Boolean {
    if(str == null) throw IllegalArgumentException("null 이 들어옴")
    return str.startsWith("A")
}

fun startWithA2(str: String?): Boolean? {
    if(str == null) return null
    return str.startsWith("A")
}

fun startWithA3(str: String?): Boolean {
    if(str == null) return false
    return str.startsWith("A")
}

fun startWithA1_1(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("null 이 들어옴")
}

fun startWithA2_2(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startWithA3_3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

//단언
fun startWithA(str: String?): Boolean {
    return str!!.startsWith("A")
}




