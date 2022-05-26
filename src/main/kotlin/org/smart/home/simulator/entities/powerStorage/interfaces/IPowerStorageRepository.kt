package org.smart.home.simulator.entities.powerStorage.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.smart.home.simulator.entities.powerStorage.PowerStorageEntity
import org.springframework.data.domain.Pageable

/**
 * Power storage repository.
 */
interface IPowerStorageRepository : ICrudlRepository<PowerStorageEntity> {

    /**
     * Returns all power storages with the given smart home ID.
     *
     * @param smartHomeId .
     * @param pageable .
     * @return List of entities.
     */
    fun findAllBySmartHomeId(smartHomeId: String, pageable: Pageable): List<PowerStorageEntity>
}
