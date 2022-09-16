package me.injin.javatokotlin.chapter02

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class Lec07

fun main() {
    //try catch finally

    //Checked Exception, UnChecked Exception
    readFile()
    println("===")
    //try with resources
    //코틀린은 해당 구문이 없고, 대신 use 라는 inline 확장함수를 사용해야 한다.
    readFileUse("./a.txt")
}

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: java.lang.NumberFormatException) {
        throw IllegalArgumentException("$str 숫자가 아님")
    }
}

fun parseIntOrThrow2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: java.lang.NumberFormatException) {
        throw IllegalArgumentException("$str 숫자가 아님")
        null
    }
}

/**
 * 자바와 다르게 코틀린에서는
 * Checked Exception 과 UnChecked Exception 을 구분하지 않습니다.
 * 모두 Unchecked Exception 으로 간주된다.
 */
fun readFile() {
    val currentFile = File(".")
    val file = File("${currentFile.absoluteFile}/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}

fun readFileUse(path: String) {
    BufferedReader(FileReader(path)).use {
        println(it.readLine())
    }
}