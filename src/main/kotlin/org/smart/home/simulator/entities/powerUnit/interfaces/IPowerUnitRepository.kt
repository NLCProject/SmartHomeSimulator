package org.smart.home.simulator.entities.powerUnit.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.smart.home.simulator.entities.powerUnit.PowerUnitEntity
import org.springframework.data.domain.Pageable

/**
 * Power unit repository.
 */
interface IPowerUnitRepository : ICrudlRepository<PowerUnitEntity> {

    /**
     * Returns all power units with the given smart home ID.
     *
     * @param smartHomeId .
     * @param pageable .
     * @return List of entities.
     */
    fun findAllBySmartHomeId(smartHomeId: String, pageable: Pageable): List<PowerUnitEntity>
}
