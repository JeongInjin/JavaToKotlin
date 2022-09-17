package me.injin.javatokotlin.etc

class Person(val name: String, val age: Int) {
    fun nextYearAge(): Int {
        println("멤버 함수")
        return this.age + 1
    }
}

