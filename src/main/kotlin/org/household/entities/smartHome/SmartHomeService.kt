package org.household.entities.smartHome

import org.household.dto.SmartHomeModel
import org.isc.utils.genericCrudl.models.Aspects
import org.isc.utils.genericCrudl.services.EntityService
import org.isc.utils.models.CurrentUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmartHomeService @Autowired constructor(
    repositoryService: SmartHomeRepository
) : EntityService<SmartHomeModel, SmartHomeEntity>(
    entityClass = SmartHomeEntity::class.java,
    repositoryService = repositoryService
) {

    override fun preSave(
        model: SmartHomeModel,
        entity: SmartHomeEntity,
        isPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun afterSave(
        model: SmartHomeModel,
        entity: SmartHomeEntity,
        wasPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun preDelete(entity: SmartHomeEntity, currentUser: CurrentUser) { }

    override fun afterDelete(entity: SmartHomeEntity, currentUser: CurrentUser) { }

    override fun checkModelAndThrow(currentUser: CurrentUser, model: SmartHomeModel) { }
}
