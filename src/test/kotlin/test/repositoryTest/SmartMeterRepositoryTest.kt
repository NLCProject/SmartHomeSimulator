package test.repositoryTest

import org.household.Application
import org.household.entities.smartMeter.SmartMeterEntity
import org.household.entities.smartMeter.SmartMeterRepository
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
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class SmartMeterRepositoryTest : RepositoryServiceTest<SmartMeterEntity>() {

    @Autowired
    private lateinit var repositoryService: SmartMeterRepository

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
    fun findBySmartHomeId() {
        val smartMeter1 = testHelperService.createSmartMeter(currentUser = currentUser)
        testHelperService.createSmartMeter(currentUser = currentUser)
        testHelperService.createSmartMeter(currentUser = currentUser)

        val smartMeterOptional = repositoryService.findBySmartHomeId(
            smartHomeId = smartMeter1.smartHome.id,
            currentUser = currentUser
        )

        assertTrue(smartMeterOptional.isPresent)
        assertEquals(smartMeter1.id, smartMeterOptional.get().id)
    }

    @Test
    fun findAllBySmartHomeId_randomId() {
        testHelperService.createSmartMeter(currentUser = currentUser)
        testHelperService.createSmartMeter(currentUser = currentUser)

        val smartMeterOptional = repositoryService.findBySmartHomeId(
            smartHomeId = Ids.getRandomId(),
            currentUser = currentUser
        )

        assertFalse(smartMeterOptional.isPresent)
    }

    override fun compareEntitiesAndThrow(entity: SmartMeterEntity, savedEntity: SmartMeterEntity) {
        DataComparatorUtil.compareEntitiesAndThrow(entity1 = entity, entity2 = savedEntity)
    }

    override fun createEntity(currentUser: CurrentUser): SmartMeterEntity =
        testHelperService.createSmartMeter(currentUser = currentUser)

    override fun preDelete(currentUser: CurrentUser, entity: SmartMeterEntity) { }
}
