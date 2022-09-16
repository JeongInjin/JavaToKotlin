package me.injin.javatokotlin.chapter02

class Lec05

fun main() {
    /**
     * statement: 프로그램의 문장, 하나의 값으로 도출되지 않는다.
     * Expression: 하나의 값으로 도출되는 문장.
     * 코틀린의 if / if-else / if-else-if 는 Expression 으로 취급되기때문에 삼항 연산자가 없다.
     */


}

fun validateScore(score: Int) {
    if(score !in 0..100) throw IllegalArgumentException("score 의 범윈는 0 부터 100 입니다.")
}

fun judgeNumber1(number: Int) {
    when (number) {
        1,2,3 -> "1,2,3"
        else -> "4,5,6"
    }

}

fun judgeNumber2(number: Int) {
    when (number) {
        is Int -> "Int"
        else -> "Not Int"
    }
}

fun judgeNumber3(number: Int) {
    when {
        number / 2 == 0 -> "number/2=0"
        else -> "asd"
    }
}