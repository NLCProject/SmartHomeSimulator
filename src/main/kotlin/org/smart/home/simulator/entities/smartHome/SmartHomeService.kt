package org.smart.home.simulator.entities.smartHome

import org.isc.utils.genericCrudl.models.Aspects
import org.isc.utils.genericCrudl.services.EntityService
import org.isc.utils.models.CurrentUser
import org.isc.utils.validation.interfaces.IEntityValidationService
import org.smart.home.simulator.dto.SmartHomeModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmartHomeService @Autowired constructor(
    private val entityValidationService: IEntityValidationService,
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

    override fun preDelete(entity: SmartHomeEntity, currentUser: CurrentUser) {
        entityValidationService.checkIfEmptyAndThrow(list = entity.electricalDevices, required = false)
        entityValidationService.checkIfEmptyAndThrow(list = entity.powerChargers, required = false)
        entityValidationService.checkIfEmptyAndThrow(list = entity.powerStorages, required = false)
        entityValidationService.checkIfEmptyAndThrow(list = entity.powerUnits, required = false)

        if (entity.smartMeter != null)
            throw Exception("Smart meter still attached")
    }

    override fun afterDelete(entity: SmartHomeEntity, currentUser: CurrentUser) { }

    override fun checkModelAndThrow(currentUser: CurrentUser, model: SmartHomeModel) { }
}
