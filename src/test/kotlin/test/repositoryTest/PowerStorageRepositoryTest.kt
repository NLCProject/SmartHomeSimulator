package test.repositoryTest

import org.household.Application
import org.household.entities.powerStorage.PowerStorageEntity
import org.household.entities.powerStorage.PowerStorageRepository
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
class PowerStorageRepositoryTest : RepositoryServiceTest<PowerStorageEntity>() {

    @Autowired
    private lateinit var repositoryService: PowerStorageRepository

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
        val storage1 = testHelperService.createPowerStorage(currentUser = currentUser)
        val storage2 = testHelperService.createPowerStorage(smartHome = storage1.smartHome, currentUser = currentUser)
        val storage3 = testHelperService.createPowerStorage(currentUser = currentUser)

        val devices = repositoryService.findAllBySmartHomeId(
            smartHomeId = storage1.smartHome.id,
            page = 0,
            currentUser = currentUser
        )

        assertEquals(2, devices.size)
        assertTrue(devices.any { it.id == storage1.id })
        assertTrue(devices.any { it.id == storage2.id })
        assertTrue(devices.none { it.id == storage3.id })
    }

    @Test
    fun findAllBySmartHomeId_randomId() {
        testHelperService.createPowerStorage(currentUser = currentUser)
        testHelperService.createPowerStorage(currentUser = currentUser)

        val devices = repositoryService.findAllBySmartHomeId(
            smartHomeId = Ids.getRandomId(),
            page = 0,
            currentUser = currentUser
        )

        assertTrue(devices.isEmpty())
    }
    
    override fun compareEntitiesAndThrow(entity: PowerStorageEntity, savedEntity: PowerStorageEntity) {
        DataComparatorUtil.compareEntitiesAndThrow(entity1 = entity, entity2 = savedEntity)
    }

    override fun createEntity(currentUser: CurrentUser): PowerStorageEntity =
        testHelperService.createPowerStorage(currentUser = currentUser)

    override fun preDelete(currentUser: CurrentUser, entity: PowerStorageEntity) { }
}
