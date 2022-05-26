package org.smart.home.simulator.entities.smartMeter.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.smart.home.simulator.entities.smartMeter.SmartMeterEntity
import java.util.*

/**
 * Smart home repository.
 */
interface ISmartMeterRepository : ICrudlRepository<SmartMeterEntity> {

    /**
     * Returns the smart meter with the given smart home ID. If the ID is unknown or no smart meter found for this ID,
     * null is returned.
     *
     * @param smartHomeId .
     * @return Smart meter DTO or null if not found.
     */
    fun findBySmartHomeId(smartHomeId: String): Optional<SmartMeterEntity>
}
