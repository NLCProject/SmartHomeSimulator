package test

import org.isc.utils.tests.I18nKeyGenerator
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.smart.home.simulator.Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertFalse

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class I18nKeyGeneratorTest {

    @Autowired
    private lateinit var service: I18nKeyGenerator

    private val pathToAssets = "./src/main/kotlin/org/smart/home/simulator/frontend/src/assets/i18n"

    @Test
    @Disabled
    fun generate() {
        service.generate(
            pathToAssets = pathToAssets,
            packageName = "org.smart.home.simulator",
            pathToSources = "./src/main/kotlin/org/smart/home/simulator/frontend/src/app",
            snackbarFunctions = listOf("showSnackbarOnError", "showSnackbar"),
            additionalI18nKeys = emptyList(),
            i18nKeysToIgnore = emptyList(),
            topLevelFoldersToInclude = listOf("details", "generics", "shared", "toolbar")
        )

        assertFalse(service.hasDuplicatedKeys(pathToAssets = pathToAssets))
        assertFalse(service.hasInvalidKeys(pathToAssets = pathToAssets))
    }
}
