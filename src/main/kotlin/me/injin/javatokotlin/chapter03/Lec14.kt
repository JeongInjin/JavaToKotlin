package me.injin.javatokotlin.chapter03

class Lec14

fun main() {
    //Data Class
    val dto1 = PersonDto("injin", 100)
    val dto2 = PersonDto("injin", 100)

    println(dto1 == dto2)
    println(dto1)

    //Enum Class


    //Sealed Class, Sealed Interface
    //Sealed Class: 컴파일때 하위 클래스의 타입을 모두 기억한다.즉 런타임때 클래스 타입이 추가될 수 없다.
        //하위 클래스는 같은 패키지에 있어야 한다.
        //Enum 과 다른 점
            //클래스를 상속받을 수 있다.
            //하위 클래스는 멀티 인스턴스가 가능하다.
    //추상화가 필요한 Entity, DTO 에 실드 클래스를 활용해 보자.
        //추가로 JDK17 에도 실드 클래스가 추가됨(문법은 다르다고함)
}

fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> println("KOKO")
        Country.AMERICA -> println("USUS")
        Country.AAA -> TODO()
    }
}

data class PersonDto(
    val name: String,
    val age: Int
)

enum class Country(
    private val code: String,
) {
    KOREA("KO"),
    AMERICA("US"),
    AAA("AA")
    ;
}

//실드 클래스 사용
sealed class CmdSealed {abstract fun execute()}

object Add : CmdSealed() {
    override fun execute() {}
}

object Delete : CmdSealed() {
    override fun execute() {}
}

fun eval(controller: CmdSealed) =
    when (controller) {
        is Add -> "추가 완료"
        is Delete -> "삭제 완료"
        // else 절 필요 없음.
    }
//실드 클래스 사용 2
sealed class HydaiCar(
    val name: String,
    val price: Long
)
class Avante: HydaiCar("아반떼", 1_234L)
class Sonata: HydaiCar("소나타", 2_345L)
class Grandeur: HydaiCar("그렌저", 3_456L)

private fun hadleCar(car: HydaiCar) {
    when (car) {
        is Avante -> TODO()
        is Grandeur -> TODO()
        is Sonata -> TODO()
    }
}


//인터페이스 사용
interface CmdInterface {fun execute()}

class AddImpl() : CmdInterface {override fun execute() {}}
class DeleteImpl() : CmdInterface {override fun execute() {}}

fun eval(controller: CmdInterface) =
    when (controller) {
        is AddImpl -> "추가 완료"
        is DeleteImpl -> "삭제 완료"
        else -> "실패" // else 절 강제 정의.
    }
