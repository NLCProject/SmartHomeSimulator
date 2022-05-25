package test.filterServiceTest

import org.household.Application
import org.household.entities.smartMeter.SmartMeterEntity
import org.household.entities.smartMeter.SmartMeterFilterService
import org.household.entities.smartMeter.SmartMeterRepository
import org.household.test.TestHelperService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.filter.FilterOptions
import org.isc.utils.models.filter.FilterParameters
import org.isc.utils.tests.FilterServiceTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.PostConstruct

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class SmartMeterFilterServiceTest : FilterServiceTest<SmartMeterEntity>() {

    @Autowired
    private lateinit var repositoryService: SmartMeterRepository

    @Autowired
    private lateinit var filterService: SmartMeterFilterService

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

    override fun findAllHints(entities: List<SmartMeterEntity>) {
        val models = filterService.findAllHints(filter = FilterParameters(), currentUser = currentUser)
        assertTrue(models.toList().isEmpty())
    }

    override fun createEntity(currentUser: CurrentUser): SmartMeterEntity =
        testHelperService.createSmartMeter(currentUser = currentUser)
}
