package org.household.entities.powerStorage

import org.household.dto.PowerStorageModel
import org.isc.utils.genericCrudl.models.Aspects
import org.isc.utils.genericCrudl.services.EntityService
import org.isc.utils.models.CurrentUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerStorageService @Autowired constructor(
    repositoryService: PowerStorageRepository
) : EntityService<PowerStorageModel, PowerStorageEntity>(
    entityClass = PowerStorageEntity::class.java,
    repositoryService = repositoryService
) {

    override fun preSave(
        model: PowerStorageModel,
        entity: PowerStorageEntity,
        isPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun afterSave(
        model: PowerStorageModel,
        entity: PowerStorageEntity,
        wasPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun preDelete(entity: PowerStorageEntity, currentUser: CurrentUser) { }

    override fun afterDelete(entity: PowerStorageEntity, currentUser: CurrentUser) { }

    override fun checkModelAndThrow(currentUser: CurrentUser, model: PowerStorageModel) { }
}
