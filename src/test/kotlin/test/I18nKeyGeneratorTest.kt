package test

import org.isc.utils.tests.I18nKeyGenerator
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

@Disabled
class I18nKeyGeneratorTest {

    private val pathToAssets = "./src/main/kotlin/org/smart/home/simulator/frontend/src/assets/i18n"

    @Test
    fun generate() {
        I18nKeyGenerator().generate(
            pathToAssets = pathToAssets,
            packageName = "org.smart.home.simulator",
            pathToSources = "./src/main/kotlin/org/smart/home/simulator/frontend/src/app",
            snackbarFunctions = listOf("showSnackbarOnError", "showSnackbar"),
            additionalI18nKeys = emptyList(),
            i18nKeysToIgnore = emptyList(),
            topLevelFoldersToInclude = listOf("details", "generics", "shared", "toolbar")
        )

        assertFalse(I18nKeyGenerator().hasDuplicatedKeys(pathToAssets = pathToAssets))
        assertFalse(I18nKeyGenerator().hasInvalidKeys(pathToAssets = pathToAssets))
    }

    @Test
    fun checkForInvalidKeys() {
        assertFalse(I18nKeyGenerator().hasInvalidKeys(pathToAssets = pathToAssets))
    }

    @Test
    fun checkForDuplicatedKeys() {
        assertFalse(I18nKeyGenerator().hasDuplicatedKeys(pathToAssets = pathToAssets))
    }
}
