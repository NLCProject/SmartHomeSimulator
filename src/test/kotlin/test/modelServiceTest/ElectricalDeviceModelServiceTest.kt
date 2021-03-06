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
import org.smart.home.simulator.dto.ElectricalDeviceModel
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceEntity
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceModelService
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceRepository
import org.smart.home.simulator.test.TestHelperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.PostConstruct
import kotlin.test.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class ElectricalDeviceModelServiceTest : ModelServiceTest<ElectricalDeviceEntity, ElectricalDeviceModel>() {

    @Autowired
    private lateinit var repositoryService: ElectricalDeviceRepository

    @Autowired
    private lateinit var modelService: ElectricalDeviceModelService

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
        val device1 = testHelperService.createElectricalDevice(currentUser = currentUser)
        val device2 = testHelperService.createElectricalDevice(smartHome = device1.smartHome, currentUser = currentUser)
        val device3 = testHelperService.createElectricalDevice(currentUser = currentUser)

        val devices = modelService.findAllBySmartHomeId(
            smartHomeId = device1.smartHome.id,
            page = 0,
            currentUser = currentUser
        )

        assertEquals(2, devices.size)
        assertTrue(devices.any { it.id == device1.id })
        assertTrue(devices.any { it.id == device2.id })
        assertTrue(devices.none { it.id == device3.id })
    }

    @Test
    fun findAllBySmartHomeId_randomId() {
        testHelperService.createElectricalDevice(currentUser = currentUser)
        testHelperService.createElectricalDevice(currentUser = currentUser)

        val devices = modelService.findAllBySmartHomeId(
            smartHomeId = Ids.getRandomId(),
            page = 0,
            currentUser = currentUser
        )

        assertTrue(devices.isEmpty())
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
        var device = testHelperService.createElectricalDevice(enabled = true, currentUser = currentUser)
        var model = modelService.findAbstractById(id = device.id, currentUser = currentUser)
        assertTrue(model.icons.isEmpty())

        device.enabled = false
        device = repositoryService.save(entity = device, currentUser = currentUser)
        model = modelService.findAbstractById(id = device.id, currentUser = currentUser)
        assertEquals(1, model.icons.size)
        assertEquals(IconEnum.POWER_OFF, model.icons.first().icon)
    }

    override fun compareEntityAndAbstractModelAndThrow(entity: ElectricalDeviceEntity, model: NamedModel) {
        assertFalse(model.firstLine.translate)
        assertTrue(model.secondLine.translate)
        assertFalse(model.thirdLine.translate)
        assertEquals(entity.name, model.firstLine.text)
        assertEquals(entity.type.name, model.secondLine.text)
        assertEquals("${entity.currentPowerConsumption}kWh", model.thirdLine.text)
        assertNull(model.thumbnail)
        assertNull(model.data)
    }

    override fun compareEntityAndModelAndThrow(entity: ElectricalDeviceEntity, model: ElectricalDeviceModel) {
        DataComparatorUtil.compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): ElectricalDeviceEntity =
        testHelperService.createElectricalDevice(currentUser = currentUser)
}
