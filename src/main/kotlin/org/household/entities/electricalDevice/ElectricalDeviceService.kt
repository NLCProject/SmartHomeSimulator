package org.household.entities.electricalDevice

import org.household.dto.ElectricalDeviceModel
import org.isc.utils.genericCrudl.models.Aspects
import org.isc.utils.genericCrudl.services.EntityService
import org.isc.utils.models.CurrentUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ElectricalDeviceService @Autowired constructor(
    repositoryService: ElectricalDeviceRepository
) : EntityService<ElectricalDeviceModel, ElectricalDeviceEntity>(
    entityClass = ElectricalDeviceEntity::class.java,
    repositoryService = repositoryService
) {

    override fun preSave(
        model: ElectricalDeviceModel,
        entity: ElectricalDeviceEntity,
        isPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun afterSave(
        model: ElectricalDeviceModel,
        entity: ElectricalDeviceEntity,
        wasPresent: Boolean,
        aspects: Aspects,
        currentUser: CurrentUser
    ) { }

    override fun preDelete(entity: ElectricalDeviceEntity, currentUser: CurrentUser) { }

    override fun afterDelete(entity: ElectricalDeviceEntity, currentUser: CurrentUser) { }

    override fun checkModelAndThrow(currentUser: CurrentUser, model: ElectricalDeviceModel) { }
}
