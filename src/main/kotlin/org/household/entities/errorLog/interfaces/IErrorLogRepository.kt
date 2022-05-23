package org.household.entities.errorLog.interfaces

import org.household.entities.errorLog.ErrorLogEntity
import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
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
