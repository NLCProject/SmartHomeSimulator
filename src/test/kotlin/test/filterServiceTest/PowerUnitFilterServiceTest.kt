package test.filterServiceTest

import org.smart.home.simulator.Application
import org.smart.home.simulator.entities.powerUnit.PowerUnitEntity
import org.smart.home.simulator.entities.powerUnit.PowerUnitFilterService
import org.smart.home.simulator.entities.powerUnit.PowerUnitRepository
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
class PowerUnitFilterServiceTest : FilterServiceTest<PowerUnitEntity>() {

    @Autowired
    private lateinit var repositoryService: PowerUnitRepository

    @Autowired
    private lateinit var filterService: PowerUnitFilterService

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

    override fun findAllHints(entities: List<PowerUnitEntity>) {
        val models = filterService.findAllHints(filter = FilterParameters(), currentUser = currentUser)
        assertTrue(models.toList().isEmpty())
    }

    override fun createEntity(currentUser: CurrentUser): PowerUnitEntity =
        testHelperService.createPowerUnit(currentUser = currentUser)
}
