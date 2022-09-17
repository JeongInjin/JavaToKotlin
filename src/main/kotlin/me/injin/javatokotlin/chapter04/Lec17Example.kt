package me.injin.javatokotlin.chapter04

class Lec17Example

fun main() {
    //3개 limit
    val productList: List<Item> = listOf(
        Item("올리브", "1"),
        Item("올리브", "2"),
        Item("무신사", "1"),
        Item("무신사", "2"),
        Item("무신사", "3"),
        Item("무신사", "4"),
        Item("무신사", "5"),
        Item("오늘의집", "1"),
        Item("오늘의집", "2"),
        Item("오늘의집", "3"),
        Item("오늘의집", "4"),
    )

    //3개의 조건만 가져오기
    val result1 = productList.filter { it.shopId == "올리브" }.take(3)
    val result2 = productList.filter { it.shopId == "무신사" }.take(3)

    //각 그룹별 3개씩 가져오기
    val results = productList
        .groupBy { it.shopId }
        .map { (shopId, productId) -> productId.take(3) }
        .flatten()
}

fun getItems(): List<Item> {
    val productList: List<Item> = listOf(
        Item("올리브", "1"),
        Item("올리브", "2"),
        Item("무신사", "1"),
        Item("무신사", "2"),
        Item("무신사", "3"),
        Item("무신사", "4"),
        Item("무신사", "5"),
        Item("오늘의집", "1"),
        Item("오늘의집", "2"),
        Item("오늘의집", "3"),
        Item("오늘의집", "4"),
    )
    return productList
}

data class Item(
    val shopId: String,
    val productId: String
)