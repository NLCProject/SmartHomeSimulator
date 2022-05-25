package org.smart.home.simulator.entities.errorLog

import org.isc.utils.genericCrudl.models.Aspects
import org.isc.utils.genericCrudl.services.EntityService
import org.isc.utils.models.CurrentUser
import org.isc.utils.services.dateTime.interfaces.IDateConversionService
import org.smart.home.simulator.dto.ErrorLogModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ErrorLogService @Autowired constructor(
    private val repositoryService: ErrorLogRepository,
    private val dateConversionService: IDateConversionService
) : EntityService<ErrorLogModel, ErrorLogEntity>(
    repositoryService = repositoryService,
    entityClass = ErrorLogEntity::class.java
) {

    override fun preSave(
        model: ErrorLogModel,
        entity: ErrorLogEntity,
        isPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) {
        if (!isPresent) {
            entity.dateCreated = dateConversionService.getCurrentDateString()
            entity.time = dateConversionService.getCurrentTimeString()
        }
    }

    override fun afterSave(
        model: ErrorLogModel,
        entity: ErrorLogEntity,
        wasPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun preDelete(entity: ErrorLogEntity, currentUser: CurrentUser) { }

    override fun afterDelete(entity: ErrorLogEntity, currentUser: CurrentUser) { }

    override fun checkModelAndThrow(currentUser: CurrentUser, model: ErrorLogModel) { }
}
