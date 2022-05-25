package test.entityServiceTest

import org.household.Application
import org.household.dto.SmartHomeModel
import org.household.entities.smartHome.SmartHomeEntity
import org.household.entities.smartHome.SmartHomeModelService
import org.household.entities.smartHome.SmartHomeRepository
import org.household.entities.smartHome.SmartHomeService
import org.household.test.TestHelperService
import org.isc.utils.models.CurrentUser
import org.isc.utils.tests.EntityServiceTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import test.modelServiceTest.SmartHomeModelServiceTest
import javax.annotation.PostConstruct

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class SmartHomeServiceTest : EntityServiceTest<SmartHomeEntity, SmartHomeModel>() {

    @Autowired
    private lateinit var repositoryService: SmartHomeRepository

    @Autowired
    private lateinit var entityService: SmartHomeService

    @Autowired
    private lateinit var modelService: SmartHomeModelService

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

    override fun preDelete(currentUser: CurrentUser, entity: SmartHomeEntity) { }

    override fun preSave(currentUser: CurrentUser) { }

    override fun afterSave(currentUser: CurrentUser, entity: SmartHomeEntity) { }

    override fun compareEntityAndModelAndThrow(
        entity: SmartHomeEntity,
        model: SmartHomeModel,
        auto: Boolean,
        currentUser: CurrentUser
    ) {
        SmartHomeModelServiceTest().compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): SmartHomeEntity =
        testHelperService.createSmartHome(currentUser = currentUser)

    override fun createModel(currentUser: CurrentUser): SmartHomeModel {
        val parent = createEntity(currentUser = currentUser)
        return modelService.findById(id = parent.id, currentUser = currentUser)
    }
}
