package me.injin.javatokotlin.chapter03

class Lec10

fun main() {
    //자바, 코틀린 모두 추상 클래스는 인스턴스화 할 수 없다.
    //자바, 코틀린 모두 인터페이스를 인스턴스화 할 수 없다.
    //코틀린에서는 backing field 가 없는 프로퍼티를 인터페이스에 만들 수 있다.


    //클래스 상속시 주의사항
    Derived(300)
    /**
     해당 소스는
        Base Class
        0
        Derived Class
     로 출력된다, ERROR!!
     Accessing non-final property number in constructor
     => 상위 클래스 생성자가 실행되는 동안
     하위 클래스의 프로퍼티 즉 Derived 를 인스턴스화 하는 (Derived 에 있는 number 에 값을 집어 넣어준다) 중인데
     이떄 상위 클래스에서 넘버를 호출하게 되면 하위클래스의 넘버를 가져오게되는데,
     아직 상위 클래스에 constructor 가 먼저 실행된 단계라서
     하위 클래스에 number 라는 값에 초기화가 이루어지지 않았다.
     그 상태에서 하위 클래스 number 에 접근하니, int 의 초기 기초값 0 이 나오게 된다.

     요약: 상위 클래스에 constructor 및 init 블럭에서는 final 이 아닌 하위클래스의 field 에 접근하면 안된다.
     상위 클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open 을 피해야 한다.
     */

    //final: override 를 할 수 없다. default 임
    //open: override 를 열어 준다, 상속 가능
    //abstract: 반드시 override 해야한다
    //override: 상위 타입을 오버라이드 하고 있다.


}

abstract class Animal(
    protected val species: String,
    protected open val legCount: Int,
) {

    abstract fun move()

}

class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("고양이가 걸어간다.")
    }

}


class Penguin(
    species: String
) : Animal(species, 2), Swinmable, Flyable {

    private val wingCount = 2

    override fun move() {
        println("펭귄이 움직인다.")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override val swimAbility: Int
        get() = 3

    override fun act() {
        super<Swinmable>.act()
        super<Flyable>.act()
    }

    override fun fly() {
        println("flyyyyyyyyyy")
    }
}

interface Flyable {
    fun act(){
        println("파닥 파닥")
    }
    fun fly()
}
interface Swinmable {

    val swimAbility: Int
        get() = 9

    fun act() {
        println("Swimable.act: $swimAbility")
        println("어푸 어푸")
    }
}

//상속시 주의사항
open class Base(
    open val number: Int = 100
){
    init {
        println("Base Class")
        println(number)
    }
}

class Derived(
    override val number: Int
) : Base() {
    init {
        println("Derived Class")
        println(number)
    }
}