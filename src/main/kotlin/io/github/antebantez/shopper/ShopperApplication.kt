package io.github.antebantez.shopper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShopperApplication

fun main(args: Array<String>) {
	runApplication<ShopperApplication>(*args)
}
