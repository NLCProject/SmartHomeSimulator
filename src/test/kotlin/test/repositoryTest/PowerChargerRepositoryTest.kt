package test.repositoryTest

import org.household.Application
import org.household.entities.powerCharger.PowerChargerEntity
import org.household.entities.powerCharger.PowerChargerRepository
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
class PowerChargerRepositoryTest : RepositoryServiceTest<PowerChargerEntity>() {

    @Autowired
    private lateinit var repositoryService: PowerChargerRepository

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
        val charger1 = testHelperService.createPowerCharger(currentUser = currentUser)
        val charger2 = testHelperService.createPowerCharger(smartHome = charger1.smartHome, currentUser = currentUser)
        val charger3 = testHelperService.createPowerCharger(currentUser = currentUser)

        val devices = repositoryService.findAllBySmartHomeId(
            smartHomeId = charger1.smartHome.id,
            page = 0,
            currentUser = currentUser
        )

        assertEquals(2, devices.size)
        assertTrue(devices.any { it.id == charger1.id })
        assertTrue(devices.any { it.id == charger2.id })
        assertTrue(devices.none { it.id == charger3.id })
    }

    @Test
    fun findAllBySmartHomeId_randomId() {
        testHelperService.createPowerCharger(currentUser = currentUser)
        testHelperService.createPowerCharger(currentUser = currentUser)

        val devices = repositoryService.findAllBySmartHomeId(
            smartHomeId = Ids.getRandomId(),
            page = 0,
            currentUser = currentUser
        )

        assertTrue(devices.isEmpty())
    }

    override fun compareEntitiesAndThrow(entity: PowerChargerEntity, savedEntity: PowerChargerEntity) {
        DataComparatorUtil.compareEntitiesAndThrow(entity1 = entity, entity2 = savedEntity)
    }

    override fun createEntity(currentUser: CurrentUser): PowerChargerEntity =
        testHelperService.createPowerCharger(currentUser = currentUser)

    override fun preDelete(currentUser: CurrentUser, entity: PowerChargerEntity) { }
}
