package org.household.entities.electricalDevice.interfaces

import org.household.entities.electricalDevice.ElectricalDeviceEntity
import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
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
