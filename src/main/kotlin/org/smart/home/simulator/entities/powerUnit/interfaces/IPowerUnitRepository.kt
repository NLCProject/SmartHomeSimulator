package org.smart.home.simulator.entities.powerUnit.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.smart.home.simulator.entities.powerUnit.PowerUnitEntity
import org.springframework.data.domain.Pageable

/**
 *
 */
interface IPowerUnitRepository : ICrudlRepository<PowerUnitEntity> {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, pageable: Pageable): List<PowerUnitEntity>
}
