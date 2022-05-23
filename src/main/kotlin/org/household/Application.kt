package org.household

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["org.household", "org.isc.utils"])
@SpringBootApplication(scanBasePackages = ["org.household", "org.isc.utils"])
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
