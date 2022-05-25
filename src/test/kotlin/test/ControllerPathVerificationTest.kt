package test

import org.junit.jupiter.api.Test
import org.reflections.Reflections
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import java.lang.reflect.Method
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ControllerPathVerificationTest {

    private val logger = LoggerFactory.getLogger(this::class.java)
    private val projectPackage = "org.smart.home.simulator"

    @Test
    fun getClasses() {
        val classes = Reflections(projectPackage).getTypesAnnotatedWith(Controller::class.java)
        logger.info("Found ${classes.size} controllers")
        val methodsWithInvalidPaths = classes
            .map { clazz ->
                clazz
                    .methods
                    .filter { isRestMethod(method = it) && hasInvalidPath(method = it) }
                    .map { Pair(clazz.simpleName, it.name) }
            }
            .flatten()
            .distinctBy { it.first + it.second }

        printLog(methods = methodsWithInvalidPaths)
        assertTrue(methodsWithInvalidPaths.isEmpty())
    }

    private fun printLog(methods: List<Pair<String, String>>) =
        methods.forEach { logger.error("Class '${it.first}' | Method '${it.second}'") }

    private fun isRestMethod(method: Method): Boolean = method.isAnnotationPresent(GetMapping::class.java) ||
        method.isAnnotationPresent(PostMapping::class.java) ||
        method.isAnnotationPresent(PutMapping::class.java) ||
        method.isAnnotationPresent(DeleteMapping::class.java)

    private fun hasInvalidPath(method: Method): Boolean {
        val values = when {
            method.isAnnotationPresent(GetMapping::class.java) -> method.getAnnotation(GetMapping::class.java).value
            method.isAnnotationPresent(PostMapping::class.java) -> method.getAnnotation(PostMapping::class.java).value
            method.isAnnotationPresent(PutMapping::class.java) -> method.getAnnotation(PutMapping::class.java).value
            else -> method.getAnnotation(DeleteMapping::class.java).value
        }

        assertEquals(1, values.size)
        return method.name != values.first().replace("/", "")
    }
}
