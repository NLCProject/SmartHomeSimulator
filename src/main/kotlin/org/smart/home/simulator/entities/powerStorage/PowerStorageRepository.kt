package org.smart.home.simulator.entities.powerStorage

import org.smart.home.simulator.entities.powerStorage.interfaces.IPowerStorageRepository
import org.isc.utils.genericCrudl.services.RepositoryService
import org.isc.utils.models.CurrentUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerStorageRepository @Autowired constructor(
    private val repository: IPowerStorageRepository
) : RepositoryService<PowerStorageEntity>(repository = repository) {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, page: Int, currentUser: CurrentUser): List<PowerStorageEntity> {
        checkFeatureAndThrow(currentUser = currentUser)
        return repository.findAllBySmartHomeId(
            smartHomeId = smartHomeId,
            pageable = paginationService.build(page = page)
        )
    }
}
