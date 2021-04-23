package com.talissonmelo.iFood

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class IFoodApplication

fun main(args: Array<String>) {
	TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
	runApplication<IFoodApplication>(*args)
}
