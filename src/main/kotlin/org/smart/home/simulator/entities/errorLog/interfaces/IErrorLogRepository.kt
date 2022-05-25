package org.smart.home.simulator.entities.errorLog.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.smart.home.simulator.entities.errorLog.ErrorLogEntity
import org.springframework.data.domain.Pageable

/**
 *
 */
interface IErrorLogRepository : ICrudlRepository<ErrorLogEntity> {

    /**
     *
     */
    fun findByHighlighted(highlighted: Boolean, pageable: Pageable): List<ErrorLogEntity>
}
