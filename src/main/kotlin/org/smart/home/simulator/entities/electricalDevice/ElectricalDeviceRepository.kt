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
     * Returns all electrical devices with the given smart home ID.
     *
     * @param smartHomeId .
     * @param page Page size. Request parameter.
     * @param currentUser .
     * @return List of entities.
     */
    fun findAllBySmartHomeId(smartHomeId: String, page: Int, currentUser: CurrentUser): List<ElectricalDeviceEntity> {
        checkFeatureAndThrow(currentUser = currentUser)
        return repository.findAllBySmartHomeId(
            smartHomeId = smartHomeId,
            pageable = paginationService.build(page = page)
        )
    }
}
