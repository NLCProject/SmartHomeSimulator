package test.repositoryTest

import org.household.Application
import org.household.entities.electricalDevice.ElectricalDeviceEntity
import org.household.entities.electricalDevice.ElectricalDeviceRepository
import org.household.test.TestHelperService
import org.isc.utils.models.CurrentUser
import org.isc.utils.tests.RepositoryServiceTest
import org.isc.utils.tests.util.DataComparatorUtil
import org.isc.utils.utils.Ids
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.PostConstruct
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class ElectricalDeviceRepositoryTest : RepositoryServiceTest<ElectricalDeviceEntity>() {

    @Autowired
    private lateinit var repositoryService: ElectricalDeviceRepository

    @Autowired
    private lateinit var testHelperService: TestHelperService

    @PostConstruct
    fun init() {
        super.init(
            service = repositoryService,
            skipDelete = false,
            expectAlwaysOnlyOneEntity = false,
            additionalRoles = mutableListOf(),
            additionalFeatures = mutableListOf()
        )
    }

    @Test
    fun findAllBySmartHomeId() {
        val device1 = testHelperService.createElectricalDevice(currentUser = currentUser)
        val device2 = testHelperService.createElectricalDevice(smartHome = device1.smartHome, currentUser = currentUser)
        val device3 = testHelperService.createElectricalDevice(currentUser = currentUser)

        val devices = repositoryService.findAllBySmartHomeId(
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

        val devices = repositoryService.findAllBySmartHomeId(
            smartHomeId = Ids.getRandomId(),
            page = 0,
            currentUser = currentUser
        )

        assertTrue(devices.isEmpty())
    }

    override fun compareEntitiesAndThrow(entity: ElectricalDeviceEntity, savedEntity: ElectricalDeviceEntity) {
        DataComparatorUtil.compareEntitiesAndThrow(entity1 = entity, entity2 = savedEntity)
    }

    override fun createEntity(currentUser: CurrentUser): ElectricalDeviceEntity =
        testHelperService.createElectricalDevice(currentUser = currentUser)

    override fun preDelete(currentUser: CurrentUser, entity: ElectricalDeviceEntity) { }
}
