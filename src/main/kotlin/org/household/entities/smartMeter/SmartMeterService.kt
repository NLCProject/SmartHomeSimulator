package org.household.entities.smartMeter

import org.household.dto.SmartMeterModel
import org.isc.utils.genericCrudl.models.Aspects
import org.isc.utils.genericCrudl.services.EntityService
import org.isc.utils.models.CurrentUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmartMeterService @Autowired constructor(
    repositoryService: SmartMeterRepository
) : EntityService<SmartMeterModel, SmartMeterEntity>(
    entityClass = SmartMeterEntity::class.java,
    repositoryService = repositoryService
) {

    override fun preSave(
        model: SmartMeterModel,
        entity: SmartMeterEntity,
        isPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun afterSave(
        model: SmartMeterModel,
        entity: SmartMeterEntity,
        wasPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun preDelete(entity: SmartMeterEntity, currentUser: CurrentUser) { }

    override fun afterDelete(entity: SmartMeterEntity, currentUser: CurrentUser) { }

    override fun checkModelAndThrow(currentUser: CurrentUser, model: SmartMeterModel) { }
}
