package me.injin.javatokotlin.chapter04

class Lec17

fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000L),
        Fruit("사과", 1_200L),
        Fruit("사과", 1_200L),
        Fruit("사과", 1_500L),
        Fruit("바나나", 3_000L),
        Fruit("바나나", 3_200L),
        Fruit("바나나", 2_500L),
        Fruit("수박", 10_000L),
    )

    val isApple0: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean { return fruit.name == "사과" }
    val isApple1 = fun(fruit: Fruit): Boolean { return fruit.name == "사과" }

    val isApple2 = {fruit: Fruit -> fruit.name == "사과"}

    println(isApple1(fruits[0]))
    println(isApple1.invoke(fruits[0]))
    println(isApple2(Fruit("사과", 3_333L)))
    println("===")

    val filterFruits0 = filterFruits(fruits, isApple0)
    val filterFruits1 = filterFruits(fruits, isApple1)
    val filterFruits2 = filterFruits(fruits, isApple2)
    val filterFruits3 = filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
    val filterFruits4 = filterFruits(fruits) { it.name == "사과" }

    println("===")

    val filter1 = fruits.getFilter { it.name == "사과" && it.price in setOf(1_000L, 3_000L, 3_200L) }
    for (fruit in filter1) {
        println("${fruit.name}: ${fruit.price}")
    }
    println("===")
    val filter2 = fruits.getFilter { it.price in setOf(1_000L, 3_000L, 3_200L) }
    for (fruit in filter2) {
        println("${fruit.name}: ${fruit.price}")
    }

    //Closure
        //자바에서는 람다를 쓸 때 사용할 수 있는 변수에 제약이 있다.
            /** ex)
                String target = "사과"
                tartget = "수박"
                filterFruits(fruits, (fruit) -> target.equals(fruit.getName());
                                                위 target 부분 에러.
             */
        //final 혹은 실질적인 final 변수만 사용 가능하다.

        //코틀린은 람다가 시작하는 지점에 참조하고 있는 변수들을 "모두 포획" 하여 그 정보를 가지고 있다. -> 클로저
        //람다가 사용되는 그 시점 람다가 쓰고 있는 다른 변수들을 모두 가지고 있어야만 진정한 1급시민으로 사용할 수 있다.

    var target = "사과"
    target = "수박"
    val filterFruits5 = filterFruits(fruits) { it.name == target }
}
class Fruit(
    val name: String,
    val price: Long
)

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}

 fun List<Fruit>.getFilter(predicate: (Fruit) -> Boolean) = filter(predicate)/*.map(predicate)*/

/**
 * 아래는 따로 정리용
 */
fun durationTest() {
    println(log.averageDurationFor(OS.WINDOWS))
    println(log.averageDurationFor(OS.MAC))

    println("==================")
    //하드코딩
    println(averageMobileDuration)

    println("==================")

    //고차함수
    println(log.averageDurationFor { it.os in setOf(OS.ANDROID, OS.IOS) })
    println(log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" })

}

// 사이트 방문 데이터 정의
data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID}

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID),
)
fun List<SiteVisit>.averageDurationFor(os: OS) = filter { it.os == os }.map { it.duration }.average()

//복잡하게 하드코딩한 필터를 사용해 데이터 붆석
val averageMobileDuration = log.filter { it.os in setOf(OS.IOS, OS.ANDROID) }.map { it.duration }.average()


//고차 함수를 사용해 중복 제거하기
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) = filter(predicate).map { it.duration }.average()

