package org.household.entities.powerStorage.interfaces

import org.household.entities.powerStorage.PowerStorageEntity
import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
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
