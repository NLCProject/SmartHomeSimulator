package org.household.entities.electricalDevice.interfaces

import org.household.entities.electricalDevice.ElectricalDeviceEntity
import org.household.entities.powerUnit.PowerUnitEntity
import org.isc.utils.genericCrudl.interfaces.ICrudlRepository

/**
 *
 */
interface IElectricalDeviceRepository : ICrudlRepository<ElectricalDeviceEntity> {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String): List<ElectricalDeviceEntity>
}
