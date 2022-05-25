package test.repositoryTest

import org.isc.utils.models.CurrentUser
import org.isc.utils.tests.RepositoryServiceTest
import org.isc.utils.tests.util.DataComparatorUtil
import org.isc.utils.utils.Ids
import org.junit.jupiter.api.Test
import org.smart.home.simulator.Application
import org.smart.home.simulator.entities.powerUnit.PowerUnitEntity
import org.smart.home.simulator.entities.powerUnit.PowerUnitRepository
import org.smart.home.simulator.test.TestHelperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.PostConstruct
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class PowerUnitRepositoryTest : RepositoryServiceTest<PowerUnitEntity>() {

    @Autowired
    private lateinit var repositoryService: PowerUnitRepository

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
        val unit1 = testHelperService.createPowerUnit(currentUser = currentUser)
        val unit2 = testHelperService.createPowerUnit(smartHome = unit1.smartHome, currentUser = currentUser)
        val unit3 = testHelperService.createPowerUnit(currentUser = currentUser)

        val devices = repositoryService.findAllBySmartHomeId(
            smartHomeId = unit1.smartHome.id,
            page = 0,
            currentUser = currentUser
        )

        assertEquals(2, devices.size)
        assertTrue(devices.any { it.id == unit1.id })
        assertTrue(devices.any { it.id == unit2.id })
        assertTrue(devices.none { it.id == unit3.id })
    }

    @Test
    fun findAllBySmartHomeId_randomId() {
        testHelperService.createPowerUnit(currentUser = currentUser)
        testHelperService.createPowerUnit(currentUser = currentUser)

        val devices = repositoryService.findAllBySmartHomeId(
            smartHomeId = Ids.getRandomId(),
            page = 0,
            currentUser = currentUser
        )

        assertTrue(devices.isEmpty())
    }

    override fun compareEntitiesAndThrow(entity: PowerUnitEntity, savedEntity: PowerUnitEntity) {
        DataComparatorUtil.compareEntitiesAndThrow(entity1 = entity, entity2 = savedEntity)
    }

    override fun createEntity(currentUser: CurrentUser): PowerUnitEntity =
        testHelperService.createPowerUnit(currentUser = currentUser)

    override fun preDelete(currentUser: CurrentUser, entity: PowerUnitEntity) { }
}
