package org.smart.home.simulator.entities.smartMeter.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.smart.home.simulator.entities.smartMeter.SmartMeterEntity
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
