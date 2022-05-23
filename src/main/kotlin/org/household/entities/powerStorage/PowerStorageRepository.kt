package org.household.entities.powerStorage

import org.household.entities.powerStorage.interfaces.IPowerStorageRepository
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
    fun findAllBySmartHomeId(smartHomeId: String, currentUser: CurrentUser): List<PowerStorageEntity> {
        checkFeatureAndThrow(currentUser = currentUser)
        return repository.findAllBySmartHomeId(smartHomeId = smartHomeId)
    }
}
