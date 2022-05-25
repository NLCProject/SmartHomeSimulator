package org.smart.home.simulator.entities.powerStorage.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.smart.home.simulator.entities.powerStorage.PowerStorageEntity
import org.springframework.data.domain.Pageable

/**
 *
 */
interface IPowerStorageRepository : ICrudlRepository<PowerStorageEntity> {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, pageable: Pageable): List<PowerStorageEntity>
}
