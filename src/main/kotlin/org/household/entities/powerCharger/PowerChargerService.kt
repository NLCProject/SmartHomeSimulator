package org.household.entities.powerCharger

import org.household.dto.PowerChargerModel
import org.household.entities.smartHome.SmartHomeRepository
import org.isc.utils.genericCrudl.models.Aspects
import org.isc.utils.genericCrudl.services.EntityService
import org.isc.utils.models.CurrentUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerChargerService @Autowired constructor(
    private val smartHomeRepoService: SmartHomeRepository,
    repositoryService: PowerChargerRepository
) : EntityService<PowerChargerModel, PowerChargerEntity>(
    entityClass = PowerChargerEntity::class.java,
    repositoryService = repositoryService
) {

    override fun preSave(
        model: PowerChargerModel,
        entity: PowerChargerEntity,
        isPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) {
        if (!isPresent)
            entity.smartHome = smartHomeRepoService.findById(id = model.smartHomeId, currentUser = currentUser)
    }

    override fun afterSave(
        model: PowerChargerModel,
        entity: PowerChargerEntity,
        wasPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun preDelete(entity: PowerChargerEntity, currentUser: CurrentUser) { }

    override fun afterDelete(entity: PowerChargerEntity, currentUser: CurrentUser) { }

    override fun checkModelAndThrow(currentUser: CurrentUser, model: PowerChargerModel) { }
}
