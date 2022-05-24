package org.household.entities.powerCharger.interfaces

import org.household.entities.powerCharger.PowerChargerEntity
import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.springframework.data.domain.Pageable

/**
 *
 */
interface IPowerChargerRepository : ICrudlRepository<PowerChargerEntity> {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, pageable: Pageable): List<PowerChargerEntity>
}
