package test.modelServiceTest

import org.isc.utils.enums.IconEnum
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.isc.utils.tests.ModelServiceTest
import org.isc.utils.tests.util.DataComparatorUtil
import org.isc.utils.utils.Ids
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.smart.home.simulator.Application
import org.smart.home.simulator.dto.PowerStorageModel
import org.smart.home.simulator.entities.powerStorage.PowerStorageEntity
import org.smart.home.simulator.entities.powerStorage.PowerStorageModelService
import org.smart.home.simulator.entities.powerStorage.PowerStorageRepository
import org.smart.home.simulator.test.TestHelperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.PostConstruct
import kotlin.test.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class PowerStorageModelServiceTest : ModelServiceTest<PowerStorageEntity, PowerStorageModel>() {

    @Autowired
    private lateinit var repositoryService: PowerStorageRepository

    @Autowired
    private lateinit var modelService: PowerStorageModelService

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
    fun findAllBySmartHomeId() {
        val storage1 = testHelperService.createPowerStorage(currentUser = currentUser)
        val storage2 = testHelperService.createPowerStorage(smartHome = storage1.smartHome, currentUser = currentUser)
        val storage3 = testHelperService.createPowerStorage(currentUser = currentUser)

        val storages = modelService.findAllBySmartHomeId(
            smartHomeId = storage1.smartHome.id,
            page = 0,
            currentUser = currentUser
        )

        assertEquals(2, storages.size)
        assertTrue(storages.any { it.id == storage1.id })
        assertTrue(storages.any { it.id == storage2.id })
        assertTrue(storages.none { it.id == storage3.id })
    }

    @Test
    fun findAllBySmartHomeId_randomId() {
        testHelperService.createPowerStorage(currentUser = currentUser)
        testHelperService.createPowerStorage(currentUser = currentUser)

        val storages = modelService.findAllBySmartHomeId(
            smartHomeId = Ids.getRandomId(),
            page = 0,
            currentUser = currentUser
        )

        assertTrue(storages.isEmpty())
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
    override fun checkAbstractIcons() {
        var storage = testHelperService.createPowerStorage(enabled = true, currentUser = currentUser)
        var model = modelService.findAbstractById(id = storage.id, currentUser = currentUser)
        assertTrue(model.icons.isEmpty())

        storage.enabled = false
        storage = repositoryService.save(entity = storage, currentUser = currentUser)
        model = modelService.findAbstractById(id = storage.id, currentUser = currentUser)
        assertEquals(1, model.icons.size)
        assertEquals(IconEnum.POWER_OFF, model.icons.first().icon)
    }

    override fun compareEntityAndAbstractModelAndThrow(entity: PowerStorageEntity, model: NamedModel) {
        assertFalse(model.firstLine.translate)
        assertFalse(model.secondLine.translate)
        assertFalse(model.thirdLine.translate)
        assertEquals(entity.name, model.firstLine.text)
        assertTrue(model.secondLine.text.isEmpty())
        assertTrue(model.thirdLine.text.isEmpty())
        assertNull(model.thumbnail)
        assertNull(model.data)
    }

    override fun compareEntityAndModelAndThrow(entity: PowerStorageEntity, model: PowerStorageModel) {
        DataComparatorUtil.compareEntityAndModelAndThrow(entity = entity, model = model)
    }

    override fun createEntity(currentUser: CurrentUser): PowerStorageEntity =
        testHelperService.createPowerStorage(currentUser = currentUser)
}
