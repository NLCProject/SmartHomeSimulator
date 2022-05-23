package org.household.entities.smartMeter

import org.household.entities.smartMeter.interfaces.ISmartMeterRepository
import org.isc.utils.genericCrudl.services.RepositoryService
import org.isc.utils.models.CurrentUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SmartMeterRepository @Autowired constructor(
    private val repository: ISmartMeterRepository
) : RepositoryService<SmartMeterEntity>(repository = repository) {

    /**
     *
     */
    fun findBySmartHomeId(smartHomeId: String, currentUser: CurrentUser): Optional<SmartMeterEntity> {
        checkFeatureAndThrow(currentUser = currentUser)
        return repository.findBySmartHomeId(smartHomeId = smartHomeId)
    }
}
