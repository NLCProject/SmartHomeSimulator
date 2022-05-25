package test.entityServiceTest

import org.smart.home.simulator.Application
import org.smart.home.simulator.dto.PowerChargerModel
import org.smart.home.simulator.entities.powerCharger.PowerChargerEntity
import org.smart.home.simulator.entities.powerCharger.PowerChargerModelService
import org.smart.home.simulator.entities.powerCharger.PowerChargerRepository
import org.smart.home.simulator.entities.powerCharger.PowerChargerService
import org.smart.home.simulator.test.TestHelperService
import org.isc.utils.models.CurrentUser
import org.isc.utils.tests.EntityServiceTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import test.modelServiceTest.PowerChargerModelServiceTest
import javax.annotation.PostConstruct

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class PowerChargerServiceTest : EntityServiceTest<PowerChargerEntity, PowerChargerModel>() {

    @Autowired
    private lateinit var repositoryService: PowerChargerRepository

    @Autowired
    private lateinit var entityService: PowerChargerService

    @Autowired
    private lateinit var modelService: PowerChargerModelService

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

    override fun preDelete(currentUser: CurrentUser, entity: PowerChargerEntity) { }

    override fun preSave(currentUser: CurrentUser) { }

    override fun afterSave(currentUser: CurrentUser, entity: PowerChargerEntity) { }

    override fun compareEntityAndModelAndThrow(
        entity: PowerChargerEntity,
        model: PowerChargerModel,
        auto: Boolean,
        currentUser: CurrentUser
    ) {
        PowerChargerModelServiceTest().compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): PowerChargerEntity =
        testHelperService.createPowerCharger(currentUser = currentUser)

    override fun createModel(currentUser: CurrentUser): PowerChargerModel {
        val parent = createEntity(currentUser = currentUser)
        return modelService.findById(id = parent.id, currentUser = currentUser)
    }
}
