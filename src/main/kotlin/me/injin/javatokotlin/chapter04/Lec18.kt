package me.injin.javatokotlin.chapter04

import kotlin.reflect.KProperty1

class Lec18

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

     //필터와 맵
        //filter, filterIndexed, map, mapIndexed, mapNotNull
        //all, none, any, count, sortedBy(기본이오름차순), sortedByDescending, distinctBy(변형된 값을 기준으로 중복을 제거한다.)
        //first(첫 번재 값을 가져온다(무조건 null 이 아니여야함), firstOrNull(첫번쟤 값 또는 null 을 가져온다)
        //last, lastOrNull
        //find(찾은 첫번째를 리턴한다, 없을경우 null)
    //다양한 컬렉션 처리 기능


    //List 를 Map 으로
    //과일이름 -> List<과일> Map 이 필요할시
    val map1: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name}

    //id(key) -> 과일 Map 이 필요할시 -> associateBy (id unique 로 활용할시)

    //key 와 value 를 모두사용
    //과일이름 -> List<가격> Map 이 필요할시
    val map2: Map<String, List<Long>> = fruits.groupBy({ fruit -> fruit.name }, { fruit -> fruit.price })

    //id -> 출고가 Map 이 필요할시 -> associateBy (id unique 로 활용할시)

    //중첩된 컬렉션 처리
    val fruitsInList: List<List<FruitDto>> = listOf(
        listOf(
            FruitDto(1L, "사과", 1_000L, 1_500L),
            FruitDto(2L, "사과", 1_200L, 1_500L),
            FruitDto(3L, "사과", 1_200L, 1_500L),
            FruitDto(4L, "사과", 1_500L, 1_500L),
            FruitDto(4L, "사과", 1_500L, 2_500L),
        ),
        listOf(
            FruitDto(5L, "바나나", 3_000L, 3_200L),
            FruitDto(6L, "바나나", 3_200L, 3_200L),
            FruitDto(7L, "바나나", 2_500L, 3_200L),
        ),
        listOf(
            FruitDto(8L, "수박", 10_000, 10_000)
        )
    )
    //출고가와 현재가가 동일한 과일을 고를시 1번째
    val samePriceFruitDto1 = fruitsInList.flatMap { list -> list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice } }
    //출고가와 현재가가 동일한 과일을 고를시 2번째
    val samePriceFruitDto2 = fruitsInList.flatMap { list -> list.samePriceFilter }

    //List<List<FruitDto>> 를 List<FruitDto> 로 그냥 바꾸어 주세요.
    val flatten = fruitsInList.flatten()
}

data class FruitDto(
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long,
) {
    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice

//    val List<FruitDto>.samePriceFilter: List<FruitDto>
//        get() = this.filter(FruitDto::isSamePrice)

}
val List<FruitDto>.samePriceFilter: List<FruitDto>
    get() = this.filter(FruitDto::isSamePrice)

