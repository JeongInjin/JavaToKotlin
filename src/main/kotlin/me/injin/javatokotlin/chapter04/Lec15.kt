package me.injin.javatokotlin.chapter04

class Lec15

fun main() {
    //배열 - 이펙티브 자바 아이템28: 배열보다 리스트를 사용하라.
    val array = arrayOf(1, 2, 3)
    for (i in array.indices) {
        println("$i, ${array[i]}")
    }
    println("===")
    array.plus(4)
    for ((i, v) in array.withIndex()) {
        println("i: $i, v: $v")
    }
    println("===")

    val newArray = array.plus(10)
    for (i in newArray) {
        println(i)
    }
    println("===")

    //코틀린 Collection -List, Set, Map
    //컬렉션을 만들어줄 때 불변인지, 가변인지를 설정해야 한다.
        //가변(Mutable) 컬렉션: 컬렉션에 element 를 추가, 삭제할 수 있다.
        //불면(Immutable) 컬렉션: 컬렉션에 element 를 추가, 삭제할 수 없다.
            //불변 컬렉션이라 하더라도, Reference Type 인 Element 의 필드는 바꿀 수 있다.(var 일경우)

    val moneyList = listOf(Money(1000), Money(2000))
    moneyList[0].price = 2222

    val numbers = listOf(100, 200)//불면리스트
    println(numbers[0])
    val emptyList = emptyList<Int>()

    val numbers2 = mutableListOf(300, 400)//가변리스트 기본 구현체는 ArrayList
    numbers2.add(500)
    numbers2[0] = 333
    println("===")
    val numberSet = setOf(111, 222)
    val numberSetMutable = mutableSetOf(333, 444)
    for (i in numberSet) {
        println(i)
    }

    val numberMap = mutableMapOf<Int, String>()//가변
    numberMap[1] = "one"
    numberMap[2] = "two"

    val mapOf = mapOf(3 to "three", 4 to "four")//불변

    println("===")
    for (key in numberMap.keys) {
        println("$key: ${numberMap[key]}")
    }
    println("===")
    for ((k, v) in numberMap.entries) {
        println("$k: $v")
    }
    for ((k, v) in numberMap) {
        println("$k: $v")
    }

    //Collection null
        //List<Int?>: 리스트에 null 이 들어갈 수 있지마, 리스트는 절대 null 이 아님.
        //List<Int>?: 리스트에는 null 이 들어갈 수 없지만, 리스트는 null 일 수 있음.
        //List<Int?>?: 리스트에 null 이 들어갈 수도 있고, 리스트가 null 일 수도 있음.
}

class Money(var price: Long)