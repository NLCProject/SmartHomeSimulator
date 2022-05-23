package org.household.entities.powerCharger

import org.household.entities.powerCharger.interfaces.IPowerChargerRepository
import org.household.entities.powerUnit.PowerUnitEntity
import org.isc.utils.genericCrudl.services.RepositoryService
import org.isc.utils.models.CurrentUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerChargerRepository @Autowired constructor(
    private val repository: IPowerChargerRepository
) : RepositoryService<PowerChargerEntity>(repository = repository) {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, currentUser: CurrentUser): List<PowerChargerEntity> {
        checkFeatureAndThrow(currentUser = currentUser)
        return repository.findAllBySmartHomeId(smartHomeId = smartHomeId)
    }
}

