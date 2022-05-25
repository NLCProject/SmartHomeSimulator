package org.smart.home.simulator.entities.electricalDevice

import org.isc.utils.genericCrudl.services.RepositoryService
import org.isc.utils.models.CurrentUser
import org.smart.home.simulator.entities.electricalDevice.interfaces.IElectricalDeviceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ElectricalDeviceRepository @Autowired constructor(
    private val repository: IElectricalDeviceRepository
) : RepositoryService<ElectricalDeviceEntity>(repository = repository) {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, page: Int, currentUser: CurrentUser): List<ElectricalDeviceEntity> {
        checkFeatureAndThrow(currentUser = currentUser)
        return repository.findAllBySmartHomeId(
            smartHomeId = smartHomeId,
            pageable = paginationService.build(page = page)
        )
    }
}