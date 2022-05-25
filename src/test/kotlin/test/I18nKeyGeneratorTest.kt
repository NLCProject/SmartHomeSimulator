package test

import org.isc.utils.tests.I18nKeyGenerator
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

class I18nKeyGeneratorTest {

    private val pathToAssets = "./src/main/kotlin/org/household/frontend/src/assets/i18n"

    @Test
    fun generate() {
        I18nKeyGenerator().generate(
            pathToAssets = pathToAssets,
            packageName = "org.household",
            pathToSources = "./src/main/kotlin/org/household/frontend/src/app",
            snackbarFunctions = emptyList(),
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
