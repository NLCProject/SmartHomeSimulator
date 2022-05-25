package test.entityServiceTest

import org.isc.utils.models.CurrentUser
import org.isc.utils.tests.EntityServiceTest
import org.junit.jupiter.api.Test
import org.smart.home.simulator.Application
import org.smart.home.simulator.dto.PowerUnitModel
import org.smart.home.simulator.entities.powerUnit.PowerUnitEntity
import org.smart.home.simulator.entities.powerUnit.PowerUnitModelService
import org.smart.home.simulator.entities.powerUnit.PowerUnitRepository
import org.smart.home.simulator.entities.powerUnit.PowerUnitService
import org.smart.home.simulator.test.TestHelperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import test.modelServiceTest.PowerUnitModelServiceTest
import javax.annotation.PostConstruct

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class PowerUnitServiceTest : EntityServiceTest<PowerUnitEntity, PowerUnitModel>() {

    @Autowired
    private lateinit var repositoryService: PowerUnitRepository

    @Autowired
    private lateinit var entityService: PowerUnitService

    @Autowired
    private lateinit var modelService: PowerUnitModelService

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

    override fun preDelete(currentUser: CurrentUser, entity: PowerUnitEntity) { }

    override fun preSave(currentUser: CurrentUser) { }

    override fun afterSave(currentUser: CurrentUser, entity: PowerUnitEntity) { }

    override fun compareEntityAndModelAndThrow(
        entity: PowerUnitEntity,
        model: PowerUnitModel,
        auto: Boolean,
        currentUser: CurrentUser
    ) {
        PowerUnitModelServiceTest().compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): PowerUnitEntity =
        testHelperService.createPowerUnit(currentUser = currentUser)

    override fun createModel(currentUser: CurrentUser): PowerUnitModel {
        val parent = createEntity(currentUser = currentUser)
        return modelService.findById(id = parent.id, currentUser = currentUser)
    }
}
