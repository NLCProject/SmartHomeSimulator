package test.modelServiceTest

import org.isc.utils.enums.IconEnum
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
import org.smart.home.simulator.Application
import org.smart.home.simulator.dto.PowerUnitModel
import org.smart.home.simulator.entities.powerUnit.PowerUnitEntity
import org.smart.home.simulator.entities.powerUnit.PowerUnitModelService
import org.smart.home.simulator.entities.powerUnit.PowerUnitRepository
import org.smart.home.simulator.test.TestHelperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.PostConstruct
import kotlin.test.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class PowerUnitModelServiceTest : ModelServiceTest<PowerUnitEntity, PowerUnitModel>() {

    @Autowired
    private lateinit var repositoryService: PowerUnitRepository

    @Autowired
    private lateinit var modelService: PowerUnitModelService

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
        val unit1 = testHelperService.createPowerUnit(currentUser = currentUser)
        val unit2 = testHelperService.createPowerUnit(smartHome = unit1.smartHome, currentUser = currentUser)
        val unit3 = testHelperService.createPowerUnit(currentUser = currentUser)

        val units = modelService.findAllBySmartHomeId(
            smartHomeId = unit1.smartHome.id,
            page = 0,
            currentUser = currentUser
        )

        assertEquals(2, units.size)
        assertTrue(units.any { it.id == unit1.id })
        assertTrue(units.any { it.id == unit2.id })
        assertTrue(units.none { it.id == unit3.id })
    }

    @Test
    fun findAllBySmartHomeId_randomId() {
        testHelperService.createPowerUnit(currentUser = currentUser)
        testHelperService.createPowerUnit(currentUser = currentUser)

        val units = modelService.findAllBySmartHomeId(
            smartHomeId = Ids.getRandomId(),
            page = 0,
            currentUser = currentUser
        )

        assertTrue(units.isEmpty())
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
    override fun checkAbstractIcons() {
        var unit = testHelperService.createPowerUnit(enabled = true, currentUser = currentUser)
        var model = modelService.findAbstractById(id = unit.id, currentUser = currentUser)
        assertTrue(model.icons.isEmpty())

        unit.enabled = false
        unit = repositoryService.save(entity = unit, currentUser = currentUser)
        model = modelService.findAbstractById(id = unit.id, currentUser = currentUser)
        assertEquals(1, model.icons.size)
        assertEquals(IconEnum.POWER_OFF, model.icons.first().icon)
    }

    override fun compareEntityAndAbstractModelAndThrow(entity: PowerUnitEntity, model: NamedModel) {
        assertFalse(model.firstLine.translate)
        assertTrue(model.secondLine.translate)
        assertFalse(model.thirdLine.translate)
        assertEquals(entity.name, model.firstLine.text)
        assertEquals(entity.type.name, model.secondLine.text)
        assertEquals("${entity.currentPowerGeneration}kWh", model.thirdLine.text)
        assertNull(model.thumbnail)
        assertNull(model.data)
    }

    override fun compareEntityAndModelAndThrow(entity: PowerUnitEntity, model: PowerUnitModel) {
        DataComparatorUtil.compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): PowerUnitEntity =
        testHelperService.createPowerUnit(currentUser = currentUser)
}
