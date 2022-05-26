package org.smart.home.simulator.entities.smartMeter

import org.isc.utils.genericCrudl.services.RepositoryService
import org.isc.utils.models.CurrentUser
import org.smart.home.simulator.entities.smartMeter.interfaces.ISmartMeterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SmartMeterRepository @Autowired constructor(
    private val repository: ISmartMeterRepository
) : RepositoryService<SmartMeterEntity>(repository = repository) {

    /**
     * Returns the optional of the smart meter with the given smart home ID. If the ID is unknown or no smart meter
     * found for this ID, the optional is empty.
     *
     * @param smartHomeId .
     * @param currentUser .
     * @return Optional.
     */
    fun findBySmartHomeId(smartHomeId: String, currentUser: CurrentUser): Optional<SmartMeterEntity> {
        checkFeatureAndThrow(currentUser = currentUser)
        return repository.findBySmartHomeId(smartHomeId = smartHomeId)
    }
}
