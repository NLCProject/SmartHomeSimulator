package org.smart.home.simulator.entities.electricalDevice.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceEntity
import org.springframework.data.domain.Pageable

/**
 * Electrical device repository.
 */
interface IElectricalDeviceRepository : ICrudlRepository<ElectricalDeviceEntity> {

    /**
     * Returns all electrical devices with the given smart home ID.
     *
     * @param smartHomeId .
     * @param pageable .
     * @return List of entities.
     */
    fun findAllBySmartHomeId(smartHomeId: String, pageable: Pageable): List<ElectricalDeviceEntity>
}
