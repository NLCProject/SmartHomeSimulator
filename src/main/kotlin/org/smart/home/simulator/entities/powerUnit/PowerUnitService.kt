package org.smart.home.simulator.entities.powerUnit

import org.isc.utils.genericCrudl.models.Aspects
import org.isc.utils.genericCrudl.services.EntityService
import org.isc.utils.models.CurrentUser
import org.smart.home.simulator.dto.PowerUnitModel
import org.smart.home.simulator.entities.smartHome.SmartHomeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerUnitService @Autowired constructor(
    private val smartHomeRepoService: SmartHomeRepository,
    repositoryService: PowerUnitRepository
) : EntityService<PowerUnitModel, PowerUnitEntity>(
    entityClass = PowerUnitEntity::class.java,
    repositoryService = repositoryService
) {

    override fun preSave(
        model: PowerUnitModel,
        entity: PowerUnitEntity,
        isPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) {
        if (!isPresent)
            entity.smartHome = smartHomeRepoService.findById(id = model.smartHomeId, currentUser = currentUser)
    }

    override fun afterSave(
        model: PowerUnitModel,
        entity: PowerUnitEntity,
        wasPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun preDelete(entity: PowerUnitEntity, currentUser: CurrentUser) { }

    override fun afterDelete(entity: PowerUnitEntity, currentUser: CurrentUser) { }

    override fun checkModelAndThrow(currentUser: CurrentUser, model: PowerUnitModel) { }
}
