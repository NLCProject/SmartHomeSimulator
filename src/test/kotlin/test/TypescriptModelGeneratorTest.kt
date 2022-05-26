package test

import org.isc.utils.tests.TypescriptModelGenerator
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

@Disabled
class TypescriptModelGeneratorTest {

    @Test
    fun generate() {
        TypescriptModelGenerator().generate(
            pathToTypescriptModels = "./src/main/kotlin/org/smart/home/simulator/frontend/src/app/models",
            subPackages = listOf("dto"),
            packageName = "org.smart.home.simulator"
        )
    }
}
