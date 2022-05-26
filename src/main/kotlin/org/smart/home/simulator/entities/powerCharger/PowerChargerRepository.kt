package org.smart.home.simulator.entities.powerCharger

import org.isc.utils.genericCrudl.services.RepositoryService
import org.isc.utils.models.CurrentUser
import org.smart.home.simulator.entities.powerCharger.interfaces.IPowerChargerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerChargerRepository @Autowired constructor(
    private val repository: IPowerChargerRepository
) : RepositoryService<PowerChargerEntity>(repository = repository) {

    /**
     * Returns all power chargers with the given smart home ID.
     *
     * @param smartHomeId .
     * @param page Page size. Request parameter.
     * @param currentUser .
     * @return List of entities.
     */
    fun findAllBySmartHomeId(smartHomeId: String, page: Int, currentUser: CurrentUser): List<PowerChargerEntity> {
        checkFeatureAndThrow(currentUser = currentUser)
        return repository.findAllBySmartHomeId(
            smartHomeId = smartHomeId,
            pageable = paginationService.build(page = page)
        )
    }
}
