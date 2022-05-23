package org.household.entities.powerStorage.interfaces

import org.household.entities.powerStorage.PowerStorageEntity
import org.household.entities.powerUnit.PowerUnitEntity
import org.isc.utils.genericCrudl.interfaces.ICrudlRepository

/**
 *
 */
interface IPowerStorageRepository : ICrudlRepository<PowerStorageEntity> {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String): List<PowerStorageEntity>
}
