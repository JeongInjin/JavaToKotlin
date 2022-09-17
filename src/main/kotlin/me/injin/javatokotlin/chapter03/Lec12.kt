package me.injin.javatokotlin.chapter03

import me.injin.javatokotlin.etc.Log
import me.injin.javatokotlin.etc.Movable

class Lec12

fun main() {
    //static 함수와 변수
    //static: 클래스가 인스턴스화 될 때 새로운 값이 복제되는게 아니라 정적으로 인스턴스끼리 값을 공유
    //companion object: 클래스와 동행하는 유일한 오브젝트
        //해당 동반객체도 하나의 객체로 간주되기 때문에, 이름을 붙일 수도 있고, interface 를 구현할 수도 있다.
        //유틸성 함수들을 넣어도 되지만 최상한 파일을 활용하는 것을 추천.
    //const: const 키워드없이 val 만 선언하면 런타임 시에 변수가 할당된다. const 를 붙이면 컴파일 시에 변수가 할당된다.
        //진짜 상수에 붙이기 위한 용도, 기본 타입과 Sting 에 붙일 수 있음.


    //@JvmStatic 애노테이션을 붙여야지 .Companion 체이닝 접근으로 가능한걸로 알았는데, 패치가 되었나 봄.
    val test1 = Person11.Companion.newBaby("test1")
    val test2 = Person11.newBaby("test2")
    val test3 = CompanionTest.Factory.newBaby("test3")
    val test4 = CompanionTest.newBaby("test4")

    //싱글톤
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a )

    //익명 클래스
    //특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스
    moveSomething(object : Movable {
        override fun move() {
            println("move~~~~")
        }

        override fun fly() {
            println("fly~~~~")
        }

    })

}
private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}

class Person11 private constructor(
    var name: String,
    var age: Int
) {
    companion object {
        private const val MIN_AGE = 1
        fun newBaby(name: String): Person11 {
            return Person11(name, MIN_AGE)
        }
    }
}

//해당 동반객체도 하나의 객체로 간주되기 때문에, 이름을 붙일 수도 있고, interface 를 구현할 수도 있다.
class CompanionTest private constructor(
    var name: String,
    var age: Int
) {
    companion object Factory : Log {
        private const val MIN_AGE = 1
        fun newBaby(name: String): CompanionTest {
            return CompanionTest(name, MIN_AGE)
        }

        override fun log() {
            println("companion class 의 동행객체 Factory.")
        }
    }
}

object Singleton {
    var a: Int = 1
}
