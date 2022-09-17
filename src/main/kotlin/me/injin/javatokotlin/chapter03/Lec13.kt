package me.injin.javatokotlin.chapter03

class Lec13

fun main() {
    //중첩 클래스의 종류
        //Static 을 사용하는 중첩 클래스: 밖의 클래스 직접 참조 불가.

        //Static 을 사용하지 않는 중첩 클래스
            // 내부 클래스(Inner Class): 밖의 클래스를 참조 가능
            // 지역 클래스(Local Class): 메소드 내부에 클래스를 정의..나도 본적이 없는듯 하다.
            // 익명 클래스(Anonymous Class): 일회성 클래스.
        //*이펙티브 자바 3rd - 아이템24, 아이템86
            /*
                1.내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어, 참조를 해지하지 못하는 경우,
                메모리 누수가 생길 수 있고, 이를 디버깅 하기 어렵다.
                2.내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있다.
                => 클래스 안에 클래스를 만들 때는 static 클래스를 사용하라.
            */


    //코틀린의 중첩 클래스와 내부 클래스
}

class House(
    private val address: String,
//    private val livingRoom: LivingRoom,
    private val bathRoom: BathRoom,
) {
    //코틀린 권장: 클래스안에 클래스 그냥 선언.(중첩 클래스)
    class LivingRoom(
        private val area: Double
    )

    //권장하지 않는 방식.(내부 클래스)
    inner class BathRoom (
        private val area: Double
    ) {
        val address: String
            get() = this@House.address
    }
}