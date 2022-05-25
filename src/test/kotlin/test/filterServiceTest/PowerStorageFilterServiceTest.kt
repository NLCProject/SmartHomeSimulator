package test.filterServiceTest

import org.smart.home.simulator.Application
import org.smart.home.simulator.entities.powerStorage.PowerStorageEntity
import org.smart.home.simulator.entities.powerStorage.PowerStorageFilterService
import org.smart.home.simulator.entities.powerStorage.PowerStorageRepository
import org.smart.home.simulator.test.TestHelperService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.filter.FilterOptions
import org.isc.utils.models.filter.FilterParameters
import org.isc.utils.tests.FilterServiceTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.PostConstruct

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class PowerStorageFilterServiceTest : FilterServiceTest<PowerStorageEntity>() {

    @Autowired
    private lateinit var repositoryService: PowerStorageRepository

    @Autowired
    private lateinit var filterService: PowerStorageFilterService

    @Autowired
    private lateinit var testHelperService: TestHelperService

    @PostConstruct
    fun init() {
        super.init(
            filterService = filterService,
            repositoryService = repositoryService,
            instancesToCreate = 2,
            additionalFeatures = mutableListOf(),
            additionalRoles = mutableListOf()
        )
    }

    override fun createFilters(filters: FilterOptions) {
        assertTrue(filters.isEmpty())
    }

    override fun findAllHints(entities: List<PowerStorageEntity>) {
        val models = filterService.findAllHints(filter = FilterParameters(), currentUser = currentUser)
        assertTrue(models.toList().isEmpty())
    }

    override fun createEntity(currentUser: CurrentUser): PowerStorageEntity =
        testHelperService.createPowerStorage(currentUser = currentUser)
}
