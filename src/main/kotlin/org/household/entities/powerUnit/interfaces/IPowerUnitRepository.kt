package org.household.entities.powerUnit.interfaces

import org.household.entities.powerUnit.PowerUnitEntity
import org.isc.utils.genericCrudl.interfaces.ICrudlRepository

/**
 *
 */
interface IPowerUnitRepository : ICrudlRepository<PowerUnitEntity> {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String): List<PowerUnitEntity>
}
