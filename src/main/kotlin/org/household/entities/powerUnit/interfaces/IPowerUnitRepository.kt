package org.household.entities.powerUnit.interfaces

import org.household.entities.powerUnit.PowerUnitEntity
import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
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
