package me.injin.javatokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JavaToKotlinApplication

fun main(args: Array<String>) {
	runApplication<JavaToKotlinApplication>(*args)
}
