package org.smart.home.simulator

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["org.smart.home.simulator", "org.isc.utils"])
@SpringBootApplication(scanBasePackages = ["org.smart.home.simulator", "org.isc.utils"])
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
