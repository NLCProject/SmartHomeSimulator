package test.entityServiceTest

import org.isc.utils.models.CurrentUser
import org.isc.utils.tests.EntityServiceTest
import org.junit.jupiter.api.Test
import org.smart.home.simulator.Application
import org.smart.home.simulator.dto.ElectricalDeviceModel
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceEntity
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceModelService
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceRepository
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceService
import org.smart.home.simulator.test.TestHelperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import test.modelServiceTest.ElectricalDeviceModelServiceTest
import javax.annotation.PostConstruct

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class ElectricalDeviceServiceTest : EntityServiceTest<ElectricalDeviceEntity, ElectricalDeviceModel>() {

    @Autowired
    private lateinit var repositoryService: ElectricalDeviceRepository

    @Autowired
    private lateinit var entityService: ElectricalDeviceService

    @Autowired
    private lateinit var modelService: ElectricalDeviceModelService

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

    override fun preDelete(currentUser: CurrentUser, entity: ElectricalDeviceEntity) { }

    override fun preSave(currentUser: CurrentUser) { }

    override fun afterSave(currentUser: CurrentUser, entity: ElectricalDeviceEntity) { }

    override fun compareEntityAndModelAndThrow(
        entity: ElectricalDeviceEntity,
        model: ElectricalDeviceModel,
        auto: Boolean,
        currentUser: CurrentUser
    ) {
        ElectricalDeviceModelServiceTest().compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): ElectricalDeviceEntity =
        testHelperService.createElectricalDevice(currentUser = currentUser)

    override fun createModel(currentUser: CurrentUser): ElectricalDeviceModel {
        val parent = createEntity(currentUser = currentUser)
        return modelService.findById(id = parent.id, currentUser = currentUser)
    }
}
