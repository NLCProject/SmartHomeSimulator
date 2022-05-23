package org.household.entities.electricalDevice

import org.household.dto.ElectricalDeviceModel
import org.isc.utils.genericCrudl.services.ModelService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ElectricalDeviceModelService @Autowired constructor(
    repositoryService: ElectricalDeviceRepository,
    filterService: ElectricalDeviceFilterService
) : ModelService<ElectricalDeviceModel, ElectricalDeviceEntity>(
    repositoryService = repositoryService,
    filterService = filterService,
    modelClass = ElectricalDeviceModel::class.java,
    abstractClass = NamedModel::class.java
) {

    override fun createModel(entity: ElectricalDeviceEntity, model: ElectricalDeviceModel, currentUser: CurrentUser) { }

    override fun createAbstractModel(entity: ElectricalDeviceEntity, model: NamedModel, currentUser: CurrentUser) { }

    override fun findAllPageable(filter: FilterParameters, page: Int, currentUser: CurrentUser): List<NamedModel> =
        throw NotImplementedError()

    override fun sortByDescending(elements: List<NamedModel>): List<NamedModel> = elements
}
