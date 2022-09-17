package me.injin.javatokotlin.chapter03

class Lec11

fun main() {
    //자바와 코틀린의 가시성 제어
    /*
    자바:
        public: 모든 곳에서 접근 가능
        protected: 같은 패키지 또는 하위 클래스에서만 접근 가능
        default: 같은 패키지에서만 접근 가능
        private: 선언된 클래스 내에서만 접근 가능

    코틀린:
        public: 모든 곳에서 접근 가능
        protected: 선언된 클래스 또는 하위 클래스에서만 접근 가능
            -> 코틀린에서는 패키지라는 개념을 namespace 관리하기 위한 용도(어떤 클래스가 어떤 패키지에 있구 영역을 나누기 위한 용도로만 쓰임)
        internal: 같은 모듈에서만 접근 가능 *모듈: 한 번에 컴파일 되는 코틀린 코드
        private: 선언된 클래스 내에서만 접근 가능

     */
    //코틀린 파일의 접근 제어
    println(StringUtil.isDirectoryPath("23561235"))
    //다양한 구성요소의 접근 제어
    //자바와 코틀린을 함께 사용할 경우 주의할
}

//다양한 구성요소의 접근 제어 - 프로퍼티
class Car(
    internal val name: String,
    private var owner: String,
    _price: Int
){
    var price = _price
        private set //setter 에만 추가로 가시성을 부여할 수 있다.
}
