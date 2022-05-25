package org.smart.home.simulator.entities.powerUnit

import org.isc.utils.genericCrudl.services.RepositoryService
import org.isc.utils.models.CurrentUser
import org.smart.home.simulator.entities.powerUnit.interfaces.IPowerUnitRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerUnitRepository @Autowired constructor(
    private val repository: IPowerUnitRepository
) : RepositoryService<PowerUnitEntity>(repository = repository) {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, page: Int, currentUser: CurrentUser): List<PowerUnitEntity> {
        checkFeatureAndThrow(currentUser = currentUser)
        return repository.findAllBySmartHomeId(
            smartHomeId = smartHomeId,
            pageable = paginationService.build(page = page)
        )
    }
}
