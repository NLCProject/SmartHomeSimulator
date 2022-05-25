package test.entityServiceTest

import org.smart.home.simulator.Application
import org.smart.home.simulator.dto.PowerStorageModel
import org.smart.home.simulator.entities.powerStorage.PowerStorageEntity
import org.smart.home.simulator.entities.powerStorage.PowerStorageModelService
import org.smart.home.simulator.entities.powerStorage.PowerStorageRepository
import org.smart.home.simulator.entities.powerStorage.PowerStorageService
import org.smart.home.simulator.test.TestHelperService
import org.isc.utils.models.CurrentUser
import org.isc.utils.tests.EntityServiceTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import test.modelServiceTest.PowerStorageModelServiceTest
import javax.annotation.PostConstruct

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class PowerStorageServiceTest : EntityServiceTest<PowerStorageEntity, PowerStorageModel>() {

    @Autowired
    private lateinit var repositoryService: PowerStorageRepository

    @Autowired
    private lateinit var entityService: PowerStorageService

    @Autowired
    private lateinit var modelService: PowerStorageModelService

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

    override fun preDelete(currentUser: CurrentUser, entity: PowerStorageEntity) { }

    override fun preSave(currentUser: CurrentUser) { }

    override fun afterSave(currentUser: CurrentUser, entity: PowerStorageEntity) { }

    override fun compareEntityAndModelAndThrow(
        entity: PowerStorageEntity,
        model: PowerStorageModel,
        auto: Boolean,
        currentUser: CurrentUser
    ) {
        PowerStorageModelServiceTest().compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): PowerStorageEntity =
        testHelperService.createPowerStorage(currentUser = currentUser)

    override fun createModel(currentUser: CurrentUser): PowerStorageModel {
        val parent = createEntity(currentUser = currentUser)
        return modelService.findById(id = parent.id, currentUser = currentUser)
    }
}
