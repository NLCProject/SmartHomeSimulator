package org.smart.home.simulator.entities.electricalDevice.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceEntity
import org.springframework.data.domain.Pageable

/**
 *
 */
interface IElectricalDeviceRepository : ICrudlRepository<ElectricalDeviceEntity> {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, pageable: Pageable): List<ElectricalDeviceEntity>
}
