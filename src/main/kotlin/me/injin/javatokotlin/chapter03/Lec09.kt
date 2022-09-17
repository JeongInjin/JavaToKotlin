package me.injin.javatokotlin.chapter03

class Lec09

fun main() {
    //클래스와 프로퍼티
    var person = Person("injin", 10)
    println(person.name)
    person.age = 20
    println(person.age)
//    var person2 = Person("injin2", 0)
    var person3 = Person("injin3")
    println(person3.age)

    //생성자와 init
    //init(초기화) 블록은 생성자가 호출되는 시점에 호출됨.

    //커스텀 getter, setter
    //객체의 속성을 나타낸다면 custom getter 형식 그외는 함수 형식이 나을듯 하다.
    var person4 = Person("injin4", 20)
    println(person4.isAdult2)
    //email 부분 참고

    var person5 = Person("injin4", 20, "eeeee")
    println(person5.email)

    var person6 = Person("injin4", 20)
    println(person6.email)

    //backing field
    /*
        주 생성자를 만들게되면(ex:var, val) getter 를 저절로 만들기 댸문에 custom getter 를 사용하기때문에
        아래쪽에 val email 을 선언하고 custom getter 를 사용했다.
        field 키워드 사용하는 이유는 get 을하게되면 해당 email 을 부르게되는데 email 은 다시 get 을 부르고,
        무한루프 형식이 일어나기 때문에 field 예약어를 사용한다.
        이를 보이지 않는 자기자신을 가리키는 필드라 하여 backing field 라 한다
        하지만 field 사용말고 더 좋은 방법이 있으니, 다른 방법을 고려해 보자.
    * */
    println("===")
    var person7 = Person("injin4", 20, "funEmail")
    println(person7.getUppercaseEmail())
    println(person7.uppercaseEmailProperty)

}

//주생성자, 보조생성자(constructor) => 보조생성자 보다는 default parameter 를 사용하자.
//어쩔수 없이 사용해야할 경우 정적 팩토리 메소드를 추천한다.

class Person(
    val name: String,
    var age: Int = 1,
    email: String = "email"
) {
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 $age 일 수 없습니다")
        }
    }

//    constructor(name: String): this(name, 1)

    fun isAdult1(): Boolean {
        return this.age >= 20
    }

    val isAdult2: Boolean
        get() = this.age >= 20
//        get() {
//            return this.age >= 20
//        }

    //backing field 비추..
    val email = email
        get() = field.uppercase()

    fun getUppercaseEmail(): String = this.email.uppercase()

    //속성을 나타내는것 같으니 해당 custom getter 추
    val uppercaseEmailProperty: String
        get() = this.email.uppercase()
}