package test.entityServiceTest

import org.isc.utils.models.CurrentUser
import org.isc.utils.tests.EntityServiceTest
import org.junit.jupiter.api.Test
import org.smart.home.simulator.Application
import org.smart.home.simulator.dto.SmartMeterModel
import org.smart.home.simulator.entities.smartMeter.SmartMeterEntity
import org.smart.home.simulator.entities.smartMeter.SmartMeterModelService
import org.smart.home.simulator.entities.smartMeter.SmartMeterRepository
import org.smart.home.simulator.entities.smartMeter.SmartMeterService
import org.smart.home.simulator.test.TestHelperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import test.modelServiceTest.SmartMeterModelServiceTest
import javax.annotation.PostConstruct

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class SmartMeterServiceTest : EntityServiceTest<SmartMeterEntity, SmartMeterModel>() {

    @Autowired
    private lateinit var repositoryService: SmartMeterRepository

    @Autowired
    private lateinit var entityService: SmartMeterService

    @Autowired
    private lateinit var modelService: SmartMeterModelService

    @Autowired
    private lateinit var testHelperService: TestHelperService

    @PostConstruct
    fun init() {
        init(
            repositoryService = repositoryService,
            entityService = entityService,
            modelService = modelService,
            additionalFeatures = mutableListOf(),
            additionalRoles = mutableListOf()
        )
    }

    @Test
    override fun deleteEntityTest() {
    }

    @Test
    override fun saveEntityTest() {
    }

    override fun preDelete(currentUser: CurrentUser, entity: SmartMeterEntity) { }

    override fun preSave(currentUser: CurrentUser) { }

    override fun afterSave(currentUser: CurrentUser, entity: SmartMeterEntity) { }

    override fun compareEntityAndModelAndThrow(
        entity: SmartMeterEntity,
        model: SmartMeterModel,
        auto: Boolean,
        currentUser: CurrentUser
    ) {
        SmartMeterModelServiceTest().compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): SmartMeterEntity =
        testHelperService.createSmartMeter(currentUser = currentUser)

    override fun createModel(currentUser: CurrentUser): SmartMeterModel {
        val parent = createEntity(currentUser = currentUser)
        return modelService.findById(id = parent.id, currentUser = currentUser)
    }
}
