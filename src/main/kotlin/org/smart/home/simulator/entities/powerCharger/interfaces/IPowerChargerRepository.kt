package org.smart.home.simulator.entities.powerCharger.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.smart.home.simulator.entities.powerCharger.PowerChargerEntity
import org.springframework.data.domain.Pageable

/**
 * Power charger repository.
 */
interface IPowerChargerRepository : ICrudlRepository<PowerChargerEntity> {

    /**
     * Returns all power chargers with the given smart home ID.
     *
     * @param smartHomeId .
     * @param pageable .
     * @return List of entities.
     */
    fun findAllBySmartHomeId(smartHomeId: String, pageable: Pageable): List<PowerChargerEntity>
}
