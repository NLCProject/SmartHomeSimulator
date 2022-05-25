package org.smart.home.simulator.entities.errorLog

import org.smart.home.simulator.entities.errorLog.interfaces.IErrorLogRepository
import org.isc.utils.enums.SortKey
import org.isc.utils.genericCrudl.services.RepositoryService
import org.isc.utils.models.CurrentUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ErrorLogRepository @Autowired constructor(
    private val repository: IErrorLogRepository
) : RepositoryService<ErrorLogEntity>(repository = repository) {

    /**
     *
     */
    fun findByHighlighted(highlighted: Boolean, page: Int, currentUser: CurrentUser): List<ErrorLogEntity> {
        checkFeatureAndThrow(currentUser = currentUser)
        return repository.findByHighlighted(
            highlighted = highlighted,
            pageable = paginationService.buildDescSort(page = page, sortKey = SortKey.TIMESTAMP_CREATED)
        )
    }
}
