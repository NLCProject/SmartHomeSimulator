package test.modelServiceTest

import org.smart.home.simulator.Application
import org.smart.home.simulator.dto.PowerChargerModel
import org.smart.home.simulator.entities.powerCharger.PowerChargerEntity
import org.smart.home.simulator.entities.powerCharger.PowerChargerModelService
import org.smart.home.simulator.entities.powerCharger.PowerChargerRepository
import org.smart.home.simulator.test.TestHelperService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.isc.utils.tests.ModelServiceTest
import org.isc.utils.tests.util.DataComparatorUtil
import org.isc.utils.utils.Ids
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.PostConstruct
import kotlin.test.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class PowerChargerModelServiceTest : ModelServiceTest<PowerChargerEntity, PowerChargerModel>() {

    @Autowired
    private lateinit var repositoryService: PowerChargerRepository

    @Autowired
    private lateinit var modelService: PowerChargerModelService

    @Autowired
    private lateinit var testHelperService: TestHelperService

    @PostConstruct
    fun init() {
        super.init(
            repositoryService = repositoryService,
            modelService = modelService,
            additionalFeatures = mutableListOf(),
            additionalRoles = mutableListOf()
        )
    }

    @Test
    fun findAllBySmartHomeId() {
        val charger1 = testHelperService.createPowerCharger(currentUser = currentUser)
        val charger2 = testHelperService.createPowerCharger(smartHome = charger1.smartHome, currentUser = currentUser)
        val charger3 = testHelperService.createPowerCharger(currentUser = currentUser)

        val chargers = modelService.findAllBySmartHomeId(
            smartHomeId = charger1.smartHome.id,
            page = 0,
            currentUser = currentUser
        )

        assertEquals(2, chargers.size)
        assertTrue(chargers.any { it.id == charger1.id })
        assertTrue(chargers.any { it.id == charger2.id })
        assertTrue(chargers.none { it.id == charger3.id })
    }

    @Test
    fun findAllBySmartHomeId_randomId() {
        testHelperService.createPowerCharger(currentUser = currentUser)
        testHelperService.createPowerCharger(currentUser = currentUser)

        val chargers = modelService.findAllBySmartHomeId(
            smartHomeId = Ids.getRandomId(),
            page = 0,
            currentUser = currentUser
        )

        assertTrue(chargers.isEmpty())
    }

    @Test
    override fun findAllPageable_withFilter() {
        createEntity(currentUser = currentUser)
        createEntity(currentUser = currentUser)

        Assertions.assertThrows(NotImplementedError::class.java) {
            modelService.findAllPageable(filter = FilterParameters(), page = 0, currentUser = currentUser)
        }
    }

    @Test
    override fun checkAbstractIcons() { }

    override fun compareEntityAndAbstractModelAndThrow(entity: PowerChargerEntity, model: NamedModel) {
        assertFalse(model.firstLine.translate)
        assertFalse(model.secondLine.translate)
        assertFalse(model.thirdLine.translate)
        assertEquals(entity.name, model.firstLine.text)
        assertTrue(model.secondLine.text.isEmpty())
        assertTrue(model.thirdLine.text.isEmpty())
        assertNull(model.thumbnail)
        assertNull(model.data)
    }

    override fun compareEntityAndModelAndThrow(entity: PowerChargerEntity, model: PowerChargerModel) {
        DataComparatorUtil.compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): PowerChargerEntity =
        testHelperService.createPowerCharger(currentUser = currentUser)
}
