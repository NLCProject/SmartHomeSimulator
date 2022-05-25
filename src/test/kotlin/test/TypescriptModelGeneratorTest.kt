package test

import org.isc.utils.tests.TypescriptModelGenerator
import org.junit.jupiter.api.Test

class TypescriptModelGeneratorTest {

    @Test
    fun generate() {
        TypescriptModelGenerator().generate(
            pathToTypescriptModels = "./src/main/kotlin/org/household/frontend/src/app/models",
            subPackages = listOf("dto"),
            packageName = "org.smart.home.simulator"
        )
    }
}
