package test.modelServiceTest

import org.household.Application
import org.household.dto.SmartMeterModel
import org.household.entities.smartMeter.SmartMeterEntity
import org.household.entities.smartMeter.SmartMeterModelService
import org.household.entities.smartMeter.SmartMeterRepository
import org.household.test.TestHelperService
import org.isc.utils.tests.util.DataComparatorUtil
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.isc.utils.tests.ModelServiceTest
import org.isc.utils.utils.Ids
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.PostConstruct
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class SmartMeterModelServiceTest : ModelServiceTest<SmartMeterEntity, SmartMeterModel>() {

    @Autowired
    private lateinit var repositoryService: SmartMeterRepository

    @Autowired
    private lateinit var modelService: SmartMeterModelService

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
    fun findBySmartHomeId() {
        val smartMeter1 = testHelperService.createSmartMeter(currentUser = currentUser)
        testHelperService.createSmartMeter(currentUser = currentUser)
        testHelperService.createSmartMeter(currentUser = currentUser)

        val smartMeter = modelService.findBySmartHomeId(
            smartHomeId = smartMeter1.smartHome.id,
            currentUser = currentUser
        )

        assertNotNull(smartMeter)
        assertEquals(smartMeter1.id, smartMeter.id)
    }

    @Test
    fun findAllBySmartHomeId_randomId() {
        testHelperService.createSmartMeter(currentUser = currentUser)
        testHelperService.createSmartMeter(currentUser = currentUser)

        val smartMeter = modelService.findBySmartHomeId(smartHomeId = Ids.getRandomId(), currentUser = currentUser)
        assertNull(smartMeter)
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
    override fun checkAbstractIcons() { }

    override fun compareEntityAndAbstractModelAndThrow(entity: SmartMeterEntity, model: NamedModel) {
        assertFalse(model.firstLine.translate)
        assertTrue(model.secondLine.translate)
        assertFalse(model.thirdLine.translate)
        assertEquals(entity.name, model.firstLine.text)
        assertEquals(entity.flowDirection.name, model.secondLine.text)
        assertTrue(model.thirdLine.text.isEmpty())
        assertNull(model.thumbnail)
        assertNull(model.data)
    }

    override fun compareEntityAndModelAndThrow(entity: SmartMeterEntity, model: SmartMeterModel) {
        DataComparatorUtil.compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): SmartMeterEntity =
        testHelperService.createSmartMeter(currentUser = currentUser)
}
