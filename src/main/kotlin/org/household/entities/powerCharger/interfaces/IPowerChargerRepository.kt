package org.household.entities.powerCharger.interfaces

import org.household.entities.powerCharger.PowerChargerEntity
import org.household.entities.powerUnit.PowerUnitEntity
import org.isc.utils.genericCrudl.interfaces.ICrudlRepository

/**
 *
 */
interface IPowerChargerRepository : ICrudlRepository<PowerChargerEntity> {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String): List<PowerChargerEntity>
}
