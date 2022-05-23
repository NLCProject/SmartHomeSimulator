package org.household.entities.smartMeter.interfaces

import org.household.entities.smartMeter.SmartMeterEntity
import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import java.util.*

/**
 *
 */
interface ISmartMeterRepository : ICrudlRepository<SmartMeterEntity> {

    /**
     *
     */
    fun findBySmartHomeId(smartHomeId: String): Optional<SmartMeterEntity>
}
