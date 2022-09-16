package me.injin.javatokotlin.chapter01

class Lec03

fun main() {
    //기본타입
    //타입 캐스팅
    val number1 = 3
    val number2:Long = 5
    val number3: Long = number1.toLong()

    printAgeIfPerson(Person2(name = "injin", age = 11))

    //코틀린의 3가지 특이한 타입
    /**
     * - Any
     *  자바의 object 역할(모든객체의 최상위 타입)
     *  모든 Primitive Type 의 최상의 타입도 Any
     *  Any 자체로는 null 을 포함할 수 없어 null 을 포함하고 싶다면, Any> 로 표현한다.
     *  Any 에 equals, hashCode, toString 존재 함.
     * - Unit
     *  Unit 은 Java 의 void 와 동일한 역할
     *  void 와 다르게 Unit 은 그 자체로 타입 인자로 사용 가능하다.
     *  함수형 프로그래밍에서 Unit 은 단 하나의 인스턴스만 갖는 타입을 의미.
     *  즉, 코틀린의 Unit 은 실제 존재하는 타입이라는 것을 표현.
     * - Nothing
     *  함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
     *  무조건 예외를 반환하는 함수 / 무한 루프 함수 등
     */
    //String Interpolation, String indexing
    //특정 문자열 가져오기
    var str = "asdfg"
    println("${str[0]}, ${str[3]}")
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person2) { //is? as? 식으로도 쓸 수 있음
        println(obj.age)
    }
}
data class Person2(val name: String, val age: Int)