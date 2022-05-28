package test

import org.isc.utils.tests.TypescriptModelGenerator
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.smart.home.simulator.Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class TypescriptModelGeneratorTest {

    @Autowired
    private lateinit var service: TypescriptModelGenerator

    @Test
    @Disabled
    fun generate() {
        service.generate(
            pathToTypescriptModels = "./src/main/kotlin/org/smart/home/simulator/frontend/src/app/models",
            subPackages = listOf("dto"),
            packageName = "org.smart.home.simulator"
        )
    }
}
